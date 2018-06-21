package com.developerbhuwan.reatil.management

import static com.developerbhuwan.reatil.management.Request.RequestCheckList


class RequestCheckListBuilder {

    String refNo
    Map<String, Integer> quotaList = new HashMap<>()

    RequestCheckListBuilder(String refNo) {
        this.refNo = refNo;
    }

    RequestCheckListBuilder addRequest(String productRefNo, int quantity) {
        quotaList.put(productRefNo, quantity)
        this
    }

    RequestCheckList build() {
        new RequestCheckList(refNo, quotaList)
    }
}
