package com.developerbhuwan.binarylibrarian;

import com.developerbhuwan.binarylibrarian.library.BookAddedEvent;
import com.developerbhuwan.binarylibrarian.shared.BookId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookAddedEventListener {

    @EventListener
    public void handle(BookAddedEvent bookAddedEvent) {
        BookId bookId = bookAddedEvent.getBookId();
    }
}
