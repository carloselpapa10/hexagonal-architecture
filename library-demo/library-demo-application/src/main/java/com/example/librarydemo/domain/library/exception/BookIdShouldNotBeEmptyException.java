package com.example.librarydemo.domain.library.exception;

import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class BookIdShouldNotBeEmptyException extends BusinessException {

    private static final String message = "BookId Should Not Be Empty Exception";

    public BookIdShouldNotBeEmptyException() {
        super(message);
    }
}
