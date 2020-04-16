package com.example.librarydemo.domain.shared_kernel.exception;

import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class NameMaxLengthException extends BusinessException {

    private static final String message = "Name Max Length Exception";

    public NameMaxLengthException() {
        super(message);
    }
}
