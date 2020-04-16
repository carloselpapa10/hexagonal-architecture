package com.example.librarydemo.domain.library;

import com.example.librarydemo.domain.library.exception.AuthorIdShouldNotBeEmptyException;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import com.example.librarydemo.domain.shared_kernel.Name;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Author {

    @Getter
    private AuthorId id;

    @Getter
    private Name name;

    @Getter
    private int age;

    public static Author build(AuthorId authorId, Name name, int age) {
        return new Author(authorId, name, age);
    }

    @Value
    @NonFinal
    public static class AuthorId {

        private final String value;

        public AuthorId(String value) throws BusinessException {

            if (value.trim().isEmpty()) {
                throw new AuthorIdShouldNotBeEmptyException();
            }

            this.value = value;
        }
    }
}
