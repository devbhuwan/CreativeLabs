package com.developerbhuwan.reatil.management;

import com.developerbhuwan.auto.retailer.ItemNotExistException;
import com.developerbhuwan.reatil.management.persistence.RequestDao;
import com.developerbhuwan.reatil.management.persistence.RequestEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRequestORMRepository implements ProductRequestRepository {

    private final RequestEvents events;
    private final RequestDao requestDao;

    @Override
    public void initNewRequest(String refNo) {

    }

    @Override
    public Request get(String refNo) {
        RequestEntity requestEntity = requestDao.findByRefNo(refNo)
                .orElseThrow(() -> new ItemNotExistException("Request not initialized for refNo: " + refNo));

        return null;
    }

    @Override
    public void save(Request request) {

    }
}
