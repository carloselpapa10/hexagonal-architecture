package com.example.librarydemo.configuration;

import com.example.librarydemo.application.library.handler.CreateLibraryCommandHandler;
import com.example.librarydemo.application.library.port.ILibraryExists;
import com.example.librarydemo.application.library.port.ISaveLibrary;
import com.example.librarydemo.application.library.usecase.AddBookToLibraryUseCase;
import com.example.librarydemo.application.library.usecase.CreateLibraryUseCase;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.persitence.driven_adapter.LibraryPersistenceAdapter;
import com.example.librarydemo.persitence.repository.LibraryRepository;
import de.triology.cb.CommandBus;
import de.triology.cb.decorator.LoggingCommandBus;
import de.triology.cb.spring.Registry;
import de.triology.cb.spring.SpringCommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //driver adapter config
    @Bean
    public CommandBus commandBus(ApplicationContext applicationContext){
        return new LoggingCommandBus(new SpringCommandBus(new Registry(applicationContext)));
    }

    //driven adapter config
    @Autowired
    private LibraryRepository libraryRepository;

    @Bean
    public LibraryPersistenceAdapter libraryPersistenceAdapter() {
        return new LibraryPersistenceAdapter(libraryRepository);
    }

    //command handlers config
    @Bean
    public CreateLibraryCommandHandler createLibraryCommandHandler(ICreateLibrary createLibrary){
        return new CreateLibraryCommandHandler(createLibrary);
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
