package com.developerbhuwan.reatil.management;

import com.developerbhuwan.reatil.management.Request.ProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@RequiredArgsConstructor
public class ProductRequestService {

    private final ProductRequestRepository repository;

    public void initNewRequest(String refNo) {
        repository.initNewRequest(refNo);
    }

    public void process(RequestList requestList) {
        Request request = repository.get(requestList.getRefNo());
        request.
    }


    @Value
    public static class RequestList {
        private final String refNo;
        private final Map<String, Integer> quotaList = new LinkedHashMap<>();

        public Set<ProductRequest> toProductRequests() {
            return quotaList.entrySet().stream().map(ProductRequest::new).collect(toSet());
        }
    }

}
