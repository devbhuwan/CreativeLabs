package com.developerbhuwan.binarylibrarian.library;

import com.developerbhuwan.binarylibrarian.shared.LibraryId;
import org.springframework.data.repository.PagingAndSortingRepository;

interface LibraryRepository extends PagingAndSortingRepository<Library, LibraryId> {
}
