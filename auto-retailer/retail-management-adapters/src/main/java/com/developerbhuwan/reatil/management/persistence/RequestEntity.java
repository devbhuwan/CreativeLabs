package com.developerbhuwan.reatil.management.persistence;

import com.developerbhuwan.auto.retailer.RefNoId;
import com.developerbhuwan.reatil.management.Request.ProductRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Request")
@Table(schema = "retail_management")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class RequestEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Version
    private Long version;
    private String refNo;
    private ProductRequest productRequest;

    public RequestEntity(String refNo) {
        this.refNo = refNo;
    }

    public RequestEntityId createId() {
        return new RequestEntityId(refNo, id);
    }

    static class RequestEntityId extends RefNoId {

        private Long id;

        RequestEntityId(String refNoId, Long id) {
            super(refNoId);
            this.id = id;
        }
    }

}
