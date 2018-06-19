package com.developerbhuwan.binarylibrarian.library.web;

import com.developerbhuwan.binarylibrarian.library.Library;
import com.developerbhuwan.binarylibrarian.library.LibraryService;
import com.developerbhuwan.binarylibrarian.shared.BookId;
import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/libraries")
public class LibraryEndpoints {

    private final LibraryService libraryService;

    public LibraryEndpoints(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<AddBookResponse> addBook(@RequestBody AddBookRequest request) {
        libraryService.addBook(new LibraryId(request.libraryId), AddBookRequest.transform(request.books));
        return new ResponseEntity<>(new AddBookResponse(), HttpStatus.OK);
    }

    @PostMapping("/add-books")
    public ResponseEntity<Library> addBook(@RequestBody AddLibraryRequest request) {
        return new ResponseEntity<>(libraryService.addLibrary(request.name), HttpStatus.CREATED);
    }

    @Value
    static class AddBookRequest {
        String libraryId;
        Map<String, Integer> books;

        static Map<BookId, Integer> transform(Map<String, Integer> books) {
            Map<BookId, Integer> booksMap = new HashMap<>();
            for (Map.Entry<String, Integer> e : books.entrySet())
                booksMap.put(new BookId(e.getKey()), e.getValue());
            return booksMap;
        }
    }

    @Value
    private static class AddBookResponse {

    }


    @RequiredArgsConstructor
    private static class AddLibraryRequest {
        private final String name;
    }
}
