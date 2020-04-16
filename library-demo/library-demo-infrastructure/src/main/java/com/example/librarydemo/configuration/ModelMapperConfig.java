package com.example.librarydemo.configuration;

import com.example.librarydemo.domain.library.Author;
import com.example.librarydemo.domain.library.Book;
import com.example.librarydemo.domain.library.Library;
import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import com.example.librarydemo.persitence.entity.AuthorEntity;
import com.example.librarydemo.persitence.entity.BookEntity;
import com.example.librarydemo.persitence.entity.LibraryEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        modelMapper.typeMap(LibraryEntity.class, CreateLibraryCommand.class).addMappings(mapper -> {
            mapper.map(src -> src.getId(), CreateLibraryCommand::setLibraryId);


            mapper.skip(CreateLibraryCommand::setAuthorAge);
            mapper.skip(CreateLibraryCommand::setAuthorId);
            mapper.skip(CreateLibraryCommand::setAuthorName);
            mapper.skip(CreateLibraryCommand::setBookId);
            mapper.skip(CreateLibraryCommand::setLibraryName);
            mapper.skip(CreateLibraryCommand::setLibraryLocation);
            mapper.skip(CreateLibraryCommand::setBookTitle);
            mapper.skip(CreateLibraryCommand::setBookYear);
        });

        modelMapper.typeMap(Author.class, AuthorEntity.class).addMappings(mapper -> {
            mapper.map(src -> src.getId().getValue(), AuthorEntity::setId);
            mapper.map(src -> src.getName().getValue(), AuthorEntity::setName);
            mapper.map(src -> src.getAge(), AuthorEntity::setAge);

            mapper.skip(AuthorEntity::setBookEntity);
        });

        modelMapper.typeMap(Book.class, BookEntity.class).addMappings(mapper -> {
            mapper.map(src -> src.getId().getValue(), BookEntity::setId);
            mapper.map(src -> src.getTitle(), BookEntity::setTitle);
            mapper.map(src -> src.getYear(), BookEntity::setYear);

            mapper.skip(BookEntity::setAuthorEntities);
            mapper.skip(BookEntity::setLibraryEntity);
        });

        modelMapper.typeMap(Library.class, LibraryEntity.class).addMappings(mapper -> {
            mapper.map(src -> src.getLibraryId().getValue(), LibraryEntity::setId);
            mapper.map(src -> src.getName().getValue(), LibraryEntity::setName);
            mapper.map(src -> src.getLocation(), LibraryEntity::setLocation);

            mapper.skip(LibraryEntity::setBookEntities);
        });

        modelMapper.validate();
        return modelMapper;
    }
}
