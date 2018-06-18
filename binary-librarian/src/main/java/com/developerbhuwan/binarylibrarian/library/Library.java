package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "BLLibrary")
public class Library extends AbstractAggregateRoot<Library> {

    @Id
    private final LibraryId id;
    @OneToMany
    private final List<LibraryBook> libraryBooks = new LinkedList<>();

    public Library(LibraryId id) {
        this.id = id;
    }

    void addBook(BookAddCommand command) {
        libraryBooks.add(new LibraryBook(command.getBookId()));
        registerEvent(new BookAddedEvent(command.getBookId()));
    }

    public long getTotalNoOfBooks(BookId bookId) {
        return libraryBooks.stream()
                .filter(b -> isEquals(bookId, b)).count();
    }

    private boolean isEquals(BookId bookId, LibraryBook b) {
        return b.getBookId().equals(bookId);
    }

}
