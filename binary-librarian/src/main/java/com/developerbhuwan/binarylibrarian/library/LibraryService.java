package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

@Component
@AllArgsConstructor
public class LibraryService {

    private final LibraryRepository repository;

    public void addBook(LibraryId libraryId, Map<BookId, Long> books) {
        Optional<Library> libraryById = repository.findById(libraryId);
        if (libraryById.isPresent()) {
            Library library = libraryById.get();
            books.entrySet().stream()
                    .map(BookAddCommand::new)
                    .forEach(library::addBook);
        } else
            throw new IllegalArgumentException(format("library not found for id [%s]", libraryId));
    }

}
