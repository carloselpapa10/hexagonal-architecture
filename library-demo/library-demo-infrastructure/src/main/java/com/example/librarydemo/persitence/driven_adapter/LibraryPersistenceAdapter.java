package com.example.librarydemo.persitence.driven_adapter;

import com.example.librarydemo.application.library.port.ILibraryExists;
import com.example.librarydemo.application.library.port.ISaveLibrary;
import com.example.librarydemo.domain.library.Library;
import com.example.librarydemo.persitence.entity.AuthorEntity;
import com.example.librarydemo.persitence.entity.BookEntity;
import com.example.librarydemo.persitence.entity.LibraryEntity;
import com.example.librarydemo.persitence.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LibraryPersistenceAdapter implements ISaveLibrary, ILibraryExists {

    private final Logger LOGGER = LoggerFactory.getLogger(LibraryPersistenceAdapter.class);

    private final LibraryRepository libraryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveLibrary(Library library) {
        LOGGER.info(String.format("Library Service : %s", library.getName()));

        Set<BookEntity> bookEntities = library.getBooks()
                .stream()
                .map(book -> {
                    Set<AuthorEntity> authors = book.getAuthors().stream()
                            .map(author -> {
                                AuthorEntity authorEntity = mapper.map(author, AuthorEntity.class);
                                authorEntity.setBookEntity(BookEntity.builder().id(book.getId().getValue()).build());
                                return authorEntity;
                            })
                            .collect(Collectors.toSet());
                    BookEntity bookEntity = mapper.map(book, BookEntity.class);
                    bookEntity.setAuthorEntities(authors);
                    bookEntity.setLibraryEntity(LibraryEntity.builder().id(library.getLibraryId().getValue()).build());
                    return bookEntity;
                })
                .collect(Collectors.toSet());
        LibraryEntity libraryEntity = mapper.map(library, LibraryEntity.class);
        libraryEntity.setBookEntities(bookEntities);
        libraryRepository.save(libraryEntity);
    }

    @Override
    public boolean libraryExists(String id) {
        return libraryRepository.existsById(id);
    }
}
