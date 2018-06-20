package com.developerbhuwan.reatil.management;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

@Value
class Request {

    private String refNo;
    private Set<ProductRequest> productRequests;
    private LocalDateTime deliveryDate;

    @Value
    static class ProductRequest {

        private final String productRefNo;
        private final int quantity;

        ProductRequest(Map.Entry<String, Integer> quota) {
            this.productRefNo = quota.getKey();
            this.quantity = quota.getValue();
        }
    }


}
