package com.example.librarydemo.application.library.handler;

import com.example.librarydemo.domain.library.command.AddBookToLibraryCommand;
import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class AddBookToLibraryCommandHandler {

    private final AddBookToLibraryCommand addBookToLibraryCommand;

    public AddBookToLibraryCommandHandler(AddBookToLibraryCommand addBookToLibraryCommand) {
        this.addBookToLibraryCommand = addBookToLibraryCommand;
    }

}
