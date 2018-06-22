package com.developerbhuwan.reatil.management;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Value
public class Request {

    private final String refNo;
    private final ProductRequest productRequest;
    private final RequestEvents events;

    void process(RequestCheckList checkList) {
        productRequest.addRequests(checkList.validRequests());
        if (productRequest.isNotEmpty())
            events.emit(new ProductsRequested(refNo, productRequest));
    }

    @Value
    public static class RequestCheckList {
        private final String refNo;
        private final Map<String, Integer> quotaList;

        Set<ProductQuota> validRequests() {
            return Collections.unmodifiableSet(quotaList.entrySet().stream()
                    .filter(e -> e.getValue() > 0)
                    .map(ProductQuota::new).collect(toSet()));
        }
    }

    @Value
    public static class ProductRequest {
        private final Set<ProductQuota> productQuotas = new LinkedHashSet<>();
        private final LocalDateTime deliveryDate;

        void addRequests(Set<ProductQuota> productQuotas) {
            this.productQuotas.addAll(productQuotas);
        }

        boolean isNotEmpty() {
            return !productQuotas.isEmpty();
        }
    }

    @Value
    @EqualsAndHashCode(exclude = "quantity")
    static class ProductQuota {

        private final String productRefNo;
        private final int quantity;

        ProductQuota(Map.Entry<String, Integer> quota) {
            this.productRefNo = quota.getKey();
            this.quantity = quota.getValue();
        }
    }


}
