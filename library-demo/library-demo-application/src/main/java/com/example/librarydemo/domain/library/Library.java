package com.example.librarydemo.domain.library;

import com.example.librarydemo.domain.library.exception.LibraryIdShouldNotBeEmptyException;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import com.example.librarydemo.domain.shared_kernel.Name;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Set;

@Value
@NonFinal
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Library {

    @Getter
    private LibraryId libraryId;

    @Getter
    private Name name;

    @Getter
    private String location;

    @Getter
    private Set<Book> books;

    public static Library build(LibraryId libraryId, @NonNull Name name, String location, @NonNull Set<Book> books) {
        return new Library(libraryId, name, location, books);
    }

    @Value
    @NonFinal
    public static class LibraryId {
        private final String value;

        public LibraryId(String value) throws BusinessException {

            //non null business exception validation
            if (value.trim().isEmpty()) {
                throw new LibraryIdShouldNotBeEmptyException();
            }

            this.value = value;
        }
    }
}
