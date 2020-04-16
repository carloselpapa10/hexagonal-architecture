package com.example.librarydemo.application.boundary;

import com.example.librarydemo.application.library.handler.AddBookToLibraryCommandHandler;
import com.example.librarydemo.application.library.handler.CreateLibraryCommandHandler;
import com.example.librarydemo.domain.library.command.AddBookToLibraryCommand;
import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.library.port.IAddBookToLibrary;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import org.requirementsascode.Model;
import org.requirementsascode.ModelRunner;

public class Boundary implements IReactToCommands {

    private Model model;

    public Boundary(ICreateLibrary createLibrary, IAddBookToLibrary addBookToLibrary) {
        model = buildModel(createLibrary, addBookToLibrary);
    }

    private Model buildModel(ICreateLibrary createLibrary, IAddBookToLibrary addBookToLibrary) {

        CreateLibraryCommandHandler createLibraryCommandHandler = new CreateLibraryCommandHandler(createLibrary);
        AddBookToLibraryCommandHandler addBookToLibraryCommandHandler = new AddBookToLibraryCommandHandler(addBookToLibrary);

        Model model = Model.builder()
                .user(CreateLibraryCommand.class).system(createLibraryCommandHandler)
                .user(AddBookToLibraryCommand.class).system(addBookToLibraryCommandHandler)
                .build();

        return model;
    }

    @Override
    public void reactTo(Object command) {
        new ModelRunner().run(model).reactTo(command);
    }
}
