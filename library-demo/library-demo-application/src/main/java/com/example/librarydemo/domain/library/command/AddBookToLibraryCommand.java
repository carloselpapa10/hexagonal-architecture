package com.example.librarydemo.domain.library.command;

import lombok.Data;

@Data
public class AddBookToLibraryCommand {

    private String libraryId;
    private String bookId;
    private String bookTitle;
    private int bookYear;
}
