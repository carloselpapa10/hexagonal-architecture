package com.example.librarydemo.web.driver_adapter;

import com.example.librarydemo.application.boundary.ILibraryOperation;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LibraryOperationAdapter {

    private final ILibraryOperation driverPort;

    public void executeOperation(Object command) throws BusinessException {
        driverPort.execute(command);
    }
}
