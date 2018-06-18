package com.developerbhuwan.autoretailer.domain.model.retail

sealed class RetailerEvents : DomainEvent

data class ProductsRequested(val requestId: RequestId) : RetailerEvents()

data class ReceivedProducts(val requestId: RequestId) : RetailerEvents()