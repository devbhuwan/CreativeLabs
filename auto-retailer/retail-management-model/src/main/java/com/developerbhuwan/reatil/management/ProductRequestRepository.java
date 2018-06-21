package com.developerbhuwan.reatil.management;

public interface ProductRequestRepository {
    void initNewRequest(String refNo);

    Request get(String refNo);

    void save(Request request);
}
