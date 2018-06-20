package com.developerbhuwan.reatil.management

import java.time.LocalDate

trait ProductRequestTrait {

    ProductRequestService.RequestList document(LocalDate date, long ... levels) {
        builder.document(date, levels)
    }


}