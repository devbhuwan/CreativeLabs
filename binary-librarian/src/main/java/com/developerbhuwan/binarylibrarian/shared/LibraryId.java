package com.developerbhuwan.binarylibrarian.shared;

import com.developerbhuwan.binarylibrarian.core.AbstractIdentifiable;
import lombok.Value;

import javax.persistence.Embeddable;

import static java.util.UUID.randomUUID;

@Value
@Embeddable
public class LibraryId implements AbstractIdentifiable<String> {

    private final String id;

    public static LibraryId newId() {
        return new LibraryId(randomUUID().toString());
    }
}
