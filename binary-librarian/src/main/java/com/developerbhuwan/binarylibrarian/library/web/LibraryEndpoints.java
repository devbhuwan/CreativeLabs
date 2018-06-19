package com.developerbhuwan.binarylibrarian.library.web;

import com.developerbhuwan.binarylibrarian.library.Library;
import com.developerbhuwan.binarylibrarian.library.LibraryService;
import com.developerbhuwan.binarylibrarian.shared.BookId;
import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/libraries")
public class LibraryEndpoints {

    private final LibraryService libraryService;

    public LibraryEndpoints(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResourceSupport root() {
        ResourceSupport rootResource = new ResourceSupport();
        rootResource.add(
                linkTo(methodOn(LibraryEndpoints.class)).withSelfRel()
        );
        return rootResource;
    }

    @PostMapping
    public ResponseEntity<Library> addBook(@RequestBody AddLibraryRequest request) {
        return new ResponseEntity<>(libraryService.addLibrary(request.name), HttpStatus.CREATED);
    }

    @PostMapping("/{library-id}/add-books")
    public ResponseEntity<AddBookResponse> addBook(@PathVariable("library-id") String libraryId, @RequestBody AddBookRequest request) {
        libraryService.addBook(new LibraryId(libraryId), AddBookRequest.transform(request.books));
        return new ResponseEntity<>(new AddBookResponse(), HttpStatus.OK);
    }

    @Value
    static class AddBookRequest {
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
