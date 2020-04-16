package com.example.librarydemo.domain.library.command;

import de.triology.cb.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLibraryCommand implements Command<String> {

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
