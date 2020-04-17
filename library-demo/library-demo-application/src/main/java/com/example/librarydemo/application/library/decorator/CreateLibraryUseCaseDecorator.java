package com.example.librarydemo.application.library.decorator;

import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.domain.shared_kernel.BusinessException;

public abstract class CreateLibraryUseCaseDecorator implements ICreateLibrary {

    private final ICreateLibrary createLibrary;

    public CreateLibraryUseCaseDecorator(ICreateLibrary createLibrary) {
        this.createLibrary = createLibrary;
    }

    @Override
    public void execute(CreateLibraryCommand command) throws BusinessException {
        createLibrary.execute(command);
    }
}
