package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.core.AbstractIdentifier;
import lombok.Value;

import javax.persistence.Embeddable;
import java.util.UUID;

@Value
@Embeddable
class LibraryBookId implements AbstractIdentifier<String> {
    private final String libraryBookId;

    public static LibraryBookId newId() {
        return new LibraryBookId(UUID.randomUUID().toString());
    }

}
