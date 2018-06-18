package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.core.DomainEvent;
import com.developerbhuwan.binarylibrarian.shared.BookId;

class BookAddedEvent extends DomainEvent {
    BookAddedEvent(BookId bookId) {
        super();
    }
}
