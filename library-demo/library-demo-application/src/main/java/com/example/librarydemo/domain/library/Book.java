package com.example.librarydemo.domain.library;

import com.example.librarydemo.domain.library.exception.BookIdShouldNotBeEmptyException;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import lombok.*;
import lombok.experimental.NonFinal;

import java.util.Set;

@Value
@NonFinal
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Book {

    @Getter
    private BookId id;

    @Getter
    private String title;

    @Getter
    private int year;

    @Getter
    private Set<Author> authors;

    public static Book build(BookId bookId, String title, int year, @NonNull Set<Author> authors) {
        return new Book(bookId, title, year, authors);
    }

    @Value
    @NonFinal
    public static class BookId {

        private final String value;

        public BookId(String value) throws BusinessException {

            //non null business exception validation
            if (value.trim().isEmpty()) {
                throw new BookIdShouldNotBeEmptyException();
            }

            this.value = value;
        }
    }
}
