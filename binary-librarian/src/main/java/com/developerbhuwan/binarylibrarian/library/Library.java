package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Entity
@Table(name = "BLLibrary")
@Getter
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Library extends AbstractAggregateRoot implements Serializable {
    @Id
    private final LibraryId libraryId;
    private final String name;
    @OneToMany(cascade = CascadeType.ALL)
    private final List<LibraryBook> libraryBooks = new LinkedList<>();

    void addBook(BookAddCommand command) {
        List<LibraryBook> newBooks = IntStream.range(0, command.getNoOfPieces())
                .mapToObj(c -> new LibraryBook(LibraryBookId.newId(), command.getBookId()))
                .collect(Collectors.toList());
        libraryBooks.addAll(newBooks);
        registerEvent(new BookAddedEvent(command.getBookId(), newBooks.size()));
    }

    long getTotalNoOfBooks(BookId bookId) {
        return libraryBooks.stream()
                .filter(b -> isEquals(bookId, b)).count();
    }

    private boolean isEquals(BookId bookId, LibraryBook b) {
        return b.getBookId().equals(bookId);
    }

}
