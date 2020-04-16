package com.example.librarydemo.application.boundary;

import com.example.librarydemo.domain.shared_kernel.BusinessException;

@FunctionalInterface
public interface ILibraryOperation {
    String execute() throws BusinessException;
}
