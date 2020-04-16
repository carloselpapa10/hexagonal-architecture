package com.example.librarydemo.configuration;

import com.example.librarydemo.application.boundary.ILibraryOperation;
import com.example.librarydemo.application.library.port.ILibraryExists;
import com.example.librarydemo.application.library.port.ISaveLibrary;
import com.example.librarydemo.application.library.usecase.AddBookToLibraryUseCase;
import com.example.librarydemo.application.library.usecase.CreateLibraryUseCase;
import com.example.librarydemo.domain.library.port.IAddBookToLibrary;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.persitence.driven_adapter.LibraryPersistenceAdapter;
import com.example.librarydemo.persitence.repository.LibraryRepository;
import com.example.librarydemo.web.driver_adapter.LibraryOperationAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //driver adapter config
//    @Bean
//    public LibraryOperationAdapter springMvcDriver(ILibraryOperation libraryOperation) {
//        return new LibraryOperationAdapter(libraryOperation);
//    }

    //driven adapter config
    @Autowired
    private LibraryRepository libraryRepository;

    @Bean
    public LibraryPersistenceAdapter libraryPersistenceAdapter() {
        return new LibraryPersistenceAdapter(libraryRepository);
    }

    //use cases config
    @Bean
    public CreateLibraryUseCase createLibraryUseCase(ISaveLibrary saveLibrary, ILibraryExists libraryExists) {
        return new CreateLibraryUseCase(saveLibrary, libraryExists);
    }

    @Bean
    public AddBookToLibraryUseCase addBookToLibraryUseCase() {
        return new AddBookToLibraryUseCase();
    }
}
