package com.developerbhuwan.reatil.management

import spock.lang.Specification

class ProductRequestServiceTest extends Specification implements ProductRequestTrait {

    def repo = Mock(ProductRequestRepository)
    def service = new ProductRequestService(repo)

    def "Repository interactions while product request initialization"() {
        given:
        def refNo = "3009000"

        when:
        service.initNewRequest(refNo)

        then:
        1 * repo.initNewRequest(refNo)
    }

    def "Repository interactions while process request"() {
        given:

        when:
        service.process()
        then:
        1 * repo.save
    }
}
