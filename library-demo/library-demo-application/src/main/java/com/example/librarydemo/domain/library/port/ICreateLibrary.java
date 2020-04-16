package com.example.librarydemo.domain.library.port;

import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.shared_kernel.BusinessException;

public interface ICreateLibrary {

    void execute(CreateLibraryCommand command) throws BusinessException;
}
