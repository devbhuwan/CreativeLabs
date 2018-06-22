package com.developerbhuwan.reatil.management

import spock.lang.Specification

import java.time.LocalDateTime

class ProductRequestServiceTest extends Specification implements ProductRequestTrait {

    def repo = null as ProductRequestService
    def service = null as ProductRequestService

    def setup() {
        repo = Mock(ProductRequestRepository)
        service = new ProductRequestService(repo)
    }

    def "Repository interactions while product request initialization"() {
        given:
        def refNo = "3009000" as String

        when:
        service.initNewRequest(refNo)

        then:
        1 * repo.initNewRequest(refNo)
    }

    def "Repository interactions and ProductRequested event also emit while process request"() {
        given:
        def refNo = "300232" as String
        def requestList = new RequestCheckListBuilder(refNo)
                .addRequest("10001", 10)
                .addRequest("10002", 5)
                .build()
        def events = Mock(RequestEvents)
        repo.get(_ as String) >> new Request(refNo, new Request.ProductRequest(LocalDateTime.now()), events)
        when:
        service.process(requestList)

        then:
        1 * repo.save(_ as Request)
        1 * events.emit(_ as ProductsRequested)
    }
}
