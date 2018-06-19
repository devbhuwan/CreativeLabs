package com.developerbhuwan.binarylibrarian.shared;

import com.developerbhuwan.binarylibrarian.core.AbstractIdentifier;
import lombok.Value;

import javax.persistence.Embeddable;
import java.util.UUID;

@Value
@Embeddable
public class BookId implements AbstractIdentifier<String> {
    private final String id;

    public static BookId newId() {
        return new BookId(UUID.randomUUID().toString());
    }
}
