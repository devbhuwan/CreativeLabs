package com.developerbhuwan.reatil.management;

import com.developerbhuwan.reatil.management.Request.RequestCheckList;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductRequestService {

    private final ProductRequestRepository repository;

    public void initNewRequest(String refNo) {
        repository.initNewRequest(refNo);
    }

    public void process(RequestCheckList requestCheckList) {
        Request model = repository.get(requestCheckList.getRefNo());
        model.process(requestCheckList);
        repository.save(model);
    }

}
