package com.developerbhuwan.reatil.management;

import com.developerbhuwan.reatil.management.Request.ProductRequest;
import lombok.Value;

import java.util.Set;

@Value
class ProductsRequested {
    private final String refNo;
    private final Set<ProductRequest> productRequests;
}
