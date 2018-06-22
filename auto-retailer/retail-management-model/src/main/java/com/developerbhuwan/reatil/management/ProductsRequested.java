package com.developerbhuwan.reatil.management;

import com.developerbhuwan.reatil.management.Request.ProductRequest;
import lombok.Value;

@Value
class ProductsRequested {
    private final String refNo;
    private final ProductRequest productQuotas;
}
