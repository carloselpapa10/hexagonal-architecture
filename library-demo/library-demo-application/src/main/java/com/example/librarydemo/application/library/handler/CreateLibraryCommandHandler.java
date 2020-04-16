package com.example.librarydemo.application.library.handler;

import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import de.triology.cb.CommandHandler;

public class CreateLibraryCommandHandler implements CommandHandler<String, CreateLibraryCommand> {

    private final ICreateLibrary createLibrary;

    public CreateLibraryCommandHandler(ICreateLibrary createLibrary) {
        this.createLibrary = createLibrary;
    }

    @Override
    public String handle(CreateLibraryCommand command) {
        try {
            createLibrary.execute(command);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
        return "OK";
    }
}
