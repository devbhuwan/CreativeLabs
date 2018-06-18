package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "BLLibraryBook")
class LibraryBook {

    @Id
    private final LibraryBookId libraryBookId;
    private final BookId bookId;


}
