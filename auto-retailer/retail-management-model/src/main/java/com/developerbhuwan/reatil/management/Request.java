package com.developerbhuwan.reatil.management;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.*;

import static java.util.stream.Collectors.toSet;

@Value
public class Request {

    private final String refNo;
    private final Set<ProductRequest> productRequests = new LinkedHashSet<>();
    private final LocalDateTime deliveryDate;
    private final RequestEvents events;

    void process(RequestCheckList checkList) {
        productRequests.addAll(checkList.validRequests());
        if (!productRequests.isEmpty())
            events.emit(new ProductsRequested(refNo, productRequests));
    }

    @Value
    public static class RequestCheckList {
        private final String refNo;
        private final Map<String, Integer> quotaList;

        Set<ProductRequest> validRequests() {
            return Collections.unmodifiableSet(quotaList.entrySet().stream()
                    .filter(e -> e.getValue() > 0)
                    .map(ProductRequest::new).collect(toSet()));
        }
    }

    @Value
    @EqualsAndHashCode(exclude = "quantity")
    static class ProductRequest {

        private final String productRefNo;
        private final int quantity;

        ProductRequest(Map.Entry<String, Integer> quota) {
            this.productRefNo = quota.getKey();
            this.quantity = quota.getValue();
        }
    }


}
