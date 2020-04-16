package com.example.librarydemo.application.library.usecase;

import com.example.librarydemo.application.library.port.ILibraryExists;
import com.example.librarydemo.application.library.port.ISaveLibrary;
import com.example.librarydemo.domain.library.Book;
import com.example.librarydemo.domain.library.Library;
import com.example.librarydemo.domain.library.Author;
import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.domain.library.exception.LibraryAlreadyExistsException;
import com.example.librarydemo.domain.library.port.ICreateLibrary;
import com.example.librarydemo.domain.shared_kernel.BusinessException;
import com.example.librarydemo.domain.shared_kernel.Name;


import java.util.Arrays;
import java.util.HashSet;

public class CreateLibraryUseCase implements ICreateLibrary {

//    private static Logger logger = LoggerFactory.getLogger(CreateLibraryUseCase.class);

    private final ISaveLibrary saveLibrary;
    private final ILibraryExists libraryExists;

    public CreateLibraryUseCase(ISaveLibrary saveLibrary, ILibraryExists libraryExists) {
        this.saveLibrary = saveLibrary;
        this.libraryExists = libraryExists;
    }

    @Override
    public void execute(CreateLibraryCommand command) throws BusinessException {
//        logger.info(String.format("Create Library Use Case : %s", command.getLibraryName()));

        Author author = Author.build(new Author.AuthorId(command.getAuthorId()), new Name(command.getAuthorName()), command.getAuthorAge());
        Book book = Book.build(new Book.BookId(command.getBookId()), command.getBookTitle(), command.getBookYear(), new HashSet<>(Arrays.asList(author)));
        Library library = Library.build(new Library.LibraryId(command.getLibraryId()), new Name(command.getLibraryName()), command.getLibraryLocation(), new HashSet<Book>(Arrays.asList(book)) {
        });

        if(libraryExists.libraryExists(library.getLibraryId().getValue())){
            throw new LibraryAlreadyExistsException();
        }

        saveLibrary.saveLibrary(library);
    }
}
