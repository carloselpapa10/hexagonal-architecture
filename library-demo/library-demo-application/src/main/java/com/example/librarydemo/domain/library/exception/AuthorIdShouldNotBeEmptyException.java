package com.example.librarydemo.domain.library.exception;

import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class AuthorIdShouldNotBeEmptyException extends BusinessException {

    private static final String message = "AuthorId Should Not Be Empty Exception";

    public AuthorIdShouldNotBeEmptyException() {
        super(message);
    }
}
