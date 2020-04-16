package com.example.librarydemo.application.library.handler;

import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;

@RequiredArgsConstructor
public class CreateLibraryCommandHandler implements Consumer<CreateLibraryCommand> {
    private final Logger LOGGER = LoggerFactory.getLogger(CreateLibraryCommandHandler.class);
    private final ICreateLibrary createLibrary;

    @Override
    public void accept(CreateLibraryCommand command) {
        try {
            createLibrary.execute(command);
        } catch (BusinessException e) {
            LOGGER.info(String.format("Create Library Business Exception %s", e));
        }
    }
}
