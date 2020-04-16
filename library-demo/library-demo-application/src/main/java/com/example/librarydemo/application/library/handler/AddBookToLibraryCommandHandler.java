package com.example.librarydemo.application.library.handler;

import com.example.librarydemo.application.boundary.ILibraryOperation;
import com.example.librarydemo.domain.library.command.AddBookToLibraryCommand;
import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class AddBookToLibraryCommandHandler implements ILibraryOperation {

    private final AddBookToLibraryCommand addBookToLibraryCommand;

    public AddBookToLibraryCommandHandler(AddBookToLibraryCommand addBookToLibraryCommand) {
        this.addBookToLibraryCommand = addBookToLibraryCommand;
    }

    @Override
    public String execute() throws BusinessException {
        return null;
    }
}
