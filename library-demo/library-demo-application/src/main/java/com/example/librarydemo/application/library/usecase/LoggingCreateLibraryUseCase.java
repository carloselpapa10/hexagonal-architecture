package com.example.librarydemo.application.library.usecase;

import com.example.librarydemo.application.library.decorator.CreateLibraryUseCaseDecorator;
import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCreateLibraryUseCase extends CreateLibraryUseCaseDecorator {

    private final Logger LOGGER = LoggerFactory.getLogger(LoggingCreateLibraryUseCase.class);

    public LoggingCreateLibraryUseCase(ICreateLibrary createLibrary) {
        super(createLibrary);
    }

    @Override
    public void execute(CreateLibraryCommand command) throws BusinessException {
        LOGGER.info("Start logging Create Library Use Case");
        super.execute(command);
        LOGGER.info("End logging Create Library Use Case");
    }
}
