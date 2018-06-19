package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "BLLibraryBook")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
class LibraryBook {

    @Id
    private final LibraryBookId libraryBookId;
    private final BookId bookId;


}
