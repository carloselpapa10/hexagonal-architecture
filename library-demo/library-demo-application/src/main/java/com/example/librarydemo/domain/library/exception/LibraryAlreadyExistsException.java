package com.example.librarydemo.domain.library.exception;

import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class LibraryAlreadyExistsException extends BusinessException {

    private final static String message = "Library Already Exists Exception";

    public LibraryAlreadyExistsException() {
        super(message);
    }
}
