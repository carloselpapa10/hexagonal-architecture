package com.example.librarydemo.domain.library.port;

import com.example.librarydemo.domain.library.command.AddBookToLibraryCommand;

public interface IAddBookToLibrary {

    void execute(AddBookToLibraryCommand command);
}
