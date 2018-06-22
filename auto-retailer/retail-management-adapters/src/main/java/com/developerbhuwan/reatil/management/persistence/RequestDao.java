package com.developerbhuwan.reatil.management.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RestResource(exported = false)
public interface RequestDao extends JpaRepository<RequestEntity, Long> {

    Optional<RequestEntity> findByRefNo(String refNo);
}
