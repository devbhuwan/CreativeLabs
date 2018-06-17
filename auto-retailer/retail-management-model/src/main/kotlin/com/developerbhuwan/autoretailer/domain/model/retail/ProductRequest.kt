package com.developerbhuwan.autoretailer.domain.model.retail

data class RequestId(val id: String)
data class CustomerId(val id: String)
data class ProductId(val id: String)
data class RequestQuantity(val id: Int)
data class RequestProduct(val productId: ProductId, val quantity: RequestQuantity)
class ProductRequest
(
        val requestId: RequestId,
        val customerId: CustomerId
) : AggregateRoot<RetailerEvents>() {


}