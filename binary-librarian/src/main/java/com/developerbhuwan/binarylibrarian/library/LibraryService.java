package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class LibraryService {

    private final LibraryRepository repository;

    public Library createNewLibrary(String name) {
        return repository.save(new Library(LibraryId.newId(), name));
    }

    public void addBook(LibraryId libraryId, Map<BookId, Integer> books) {
        Optional<Library> libraryById = repository.findById(libraryId);
        if (libraryById.isPresent()) {
            Library library = libraryById.get();
            books.entrySet().stream()
                    .map(BookAddCommand::new)
                    .forEach(library::addBook);
            repository.save(library);
        } else
            throw new IllegalArgumentException(format("library not found for id [%s]", libraryId));
    }

}
