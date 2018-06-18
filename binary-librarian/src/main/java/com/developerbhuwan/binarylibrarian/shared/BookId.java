package com.developerbhuwan.binarylibrarian.shared;

import com.developerbhuwan.binarylibrarian.core.AbstractIdentifiable;
import lombok.Value;

import javax.persistence.Embeddable;

@Value
@Embeddable
public class BookId implements AbstractIdentifiable<String> {
    private final String id;
}
