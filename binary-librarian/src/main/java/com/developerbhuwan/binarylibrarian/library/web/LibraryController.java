package com.developerbhuwan.binarylibrarian.library.web;

import com.developerbhuwan.binarylibrarian.library.LibraryService;
import com.developerbhuwan.binarylibrarian.shared.BookId;
import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public ResponseEntity<AddBookResponse> addBook(AddBookRequest request) {
        libraryService.addBook(new LibraryId(request.libraryId), AddBookRequest.transform(request.books));
        return new ResponseEntity<>(new AddBookResponse(), HttpStatus.OK);
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
    static class AddBookResponse {

    }
}
