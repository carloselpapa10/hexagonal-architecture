package com.example.librarydemo.application.library.handler;

import com.example.librarydemo.application.boundary.ILibraryOperation;
import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class CreateLibraryCommandHandler implements ILibraryOperation {

    private final CreateLibraryCommand createLibraryCommand;

    public CreateLibraryCommandHandler(CreateLibraryCommand createLibraryCommand) {
        this.createLibraryCommand = createLibraryCommand;
    }

    @Override
    public String execute() throws BusinessException {
        return null;
    }
}
