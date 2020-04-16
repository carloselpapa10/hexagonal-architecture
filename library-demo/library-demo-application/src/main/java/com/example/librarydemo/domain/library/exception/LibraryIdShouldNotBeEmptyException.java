package com.example.librarydemo.domain.library.exception;

import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class LibraryIdShouldNotBeEmptyException extends BusinessException {

    private static final String message = "LibraryId Should Not Be Empty Exception";

    public LibraryIdShouldNotBeEmptyException() {
        super(message);
    }
}
