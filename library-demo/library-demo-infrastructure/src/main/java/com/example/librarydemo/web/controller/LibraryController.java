package com.example.librarydemo.web.controller;

import com.example.librarydemo.domain.library.command.CreateLibraryCommand;
import de.triology.cb.CommandBus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/library")
public class LibraryController {

    private final Logger LOGGER = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommandBus commandBus;

    @PostMapping
    public void insertLibrary(@RequestBody LibraryDto libraryDto) {

        LOGGER.info("Library Controller");

        CreateLibraryCommand command = modelMapper.map(libraryDto, CreateLibraryCommand.class);
        String result = commandBus.execute(command);

        LOGGER.info(result);
    }
}

@Data
class LibraryDto {
    private String libraryId;
    private String libraryName;
    private String libraryLocation;
    private String bookId;
    private String bookTitle;
    private int bookYear;
    private String authorId;
    private String authorName;
    private int authorAge;
}
