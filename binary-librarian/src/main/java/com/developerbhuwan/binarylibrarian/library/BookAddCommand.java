package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.core.Command;
import com.developerbhuwan.binarylibrarian.shared.BookId;
import lombok.Value;

import java.util.Map;

/**
 * A command from a given Librarian which will trigger event {@link BookAddedEvent}
 * <p>
 * Librarian -> {@link BookAddCommand} -> {@link BookAddedEvent}
 *
 * @author Bhuwan P. Upadhyay
 */
@Value
class BookAddCommand extends Command {

    private final BookId bookId;
    private final Integer noOfPiece;

    public BookAddCommand(Map.Entry<BookId, Integer> detail) {
        this.bookId = detail.getKey();
        this.noOfPiece = detail.getValue();
    }
}
