package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.core.DomainEvent;
import com.developerbhuwan.binarylibrarian.shared.BookId;
import lombok.Value;

/**
 * An event the result of {@link BookAddCommand}
 *
 * @author Bhuwan P. Upadhyay
 */
@Value
public class BookAddedEvent extends DomainEvent {
    private final BookId bookId;
}


