package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.BookId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "BLLibraryBook")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
class LibraryBook {

    @Id
    private final LibraryBookId libraryBookId;
    private final BookId bookId;


}
