package com.developerbhuwan.binarylibrarian;

import com.developerbhuwan.binarylibrarian.library.BookAddedEvent;
import com.developerbhuwan.binarylibrarian.shared.BookId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
public class BookAddedEventListener {

    @TransactionalEventListener
    public void handle(BookAddedEvent bookAddedEvent) {
        BookId bookId = bookAddedEvent.getBookId();
    }
}
