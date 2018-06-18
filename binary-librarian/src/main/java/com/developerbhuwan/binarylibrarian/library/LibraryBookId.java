package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.core.AbstractIdentifiable;
import lombok.Value;

import java.util.UUID;

@Value
class LibraryBookId implements AbstractIdentifiable<String> {
    private final String id;

    public static LibraryBookId newId() {
        return new LibraryBookId(UUID.randomUUID().toString());
    }

}
