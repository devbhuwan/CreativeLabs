package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryServiceIntegrationTest extends AbstractIntegrationTest {

    private static final int FOUR = 4;
    private static final int SIX = 6;
    @Autowired
    private LibraryService libraryService;

    @Test
    void addBookInLibrary() {
        Library library = libraryService.createNewLibrary("ABC Chemistry");

        BookId firstBookId = BookId.newId();
        BookId secondBookId = BookId.newId();

        Map<BookId, Integer> books = Maps.newHashMap(firstBookId, FOUR);
        books.put(secondBookId, SIX);

        libraryService.addBook(library.getLibraryId(), books);

        assertEquals(FOUR, library.getTotalNoOfBooks(firstBookId));
        assertEquals(SIX, library.getTotalNoOfBooks(secondBookId));
    }
}