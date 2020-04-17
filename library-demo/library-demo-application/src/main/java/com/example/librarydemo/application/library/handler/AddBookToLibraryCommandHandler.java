package com.example.librarydemo.application.library.handler;

import com.example.librarydemo.domain.library.command.AddBookToLibraryCommand;

public class AddBookToLibraryCommandHandler {

    private final AddBookToLibraryCommand addBookToLibraryCommand;

    public AddBookToLibraryCommandHandler(AddBookToLibraryCommand addBookToLibraryCommand) {
        this.addBookToLibraryCommand = addBookToLibraryCommand;
    }

}
