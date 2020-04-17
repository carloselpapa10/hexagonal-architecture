package com.example.librarydemo.application.library.usecase;

import com.example.librarydemo.application.library.decorator.CreateLibraryUseCaseDecorator;
import com.example.librarydemo.application.shared.port.IPublish;
import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.domain.shared_kernel.BusinessException;

public class PublishCreateLibraryUseCase extends CreateLibraryUseCaseDecorator {

    private final IPublish publish;

    public PublishCreateLibraryUseCase(ICreateLibrary createLibrary, IPublish publish) {
        super(createLibrary);
        this.publish = publish;
    }

    @Override
    public void execute(CreateLibraryCommand command) throws BusinessException {
        super.execute(command);
        publish.publishMessage(command.getLibraryName());
    }
}
