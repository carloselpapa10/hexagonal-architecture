package com.example.librarydemo.web.driver_adapter;

import com.example.librarydemo.application.boundary.ILibraryOperation;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LibraryOperationAdapter {

    public void executeOperation(ILibraryOperation libraryOperation) throws BusinessException {
        libraryOperation.execute();
    }
}
