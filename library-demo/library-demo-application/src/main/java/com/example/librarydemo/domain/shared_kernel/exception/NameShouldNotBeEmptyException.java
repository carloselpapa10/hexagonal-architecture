package com.example.librarydemo.domain.shared_kernel.exception;

import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class NameShouldNotBeEmptyException extends BusinessException {

    private static final String message = "Name Should Not Be Empty Exception";

    public NameShouldNotBeEmptyException() {
        super(message);
    }
}
