package com.example.librarydemo.application.library.handler;

import com.example.librarydemo.domain.library.command.AddBookToLibraryCommand;
import com.example.librarydemo.domain.library.port.IAddBookToLibrary;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class AddBookToLibraryCommandHandler implements Consumer<AddBookToLibraryCommand> {

    private final IAddBookToLibrary addBookToLibrary;

    @Override
    public void accept(AddBookToLibraryCommand command) {
        addBookToLibrary.execute(command);
    }
}
