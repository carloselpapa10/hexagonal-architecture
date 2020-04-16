package com.example.librarydemo.persitence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "authorEntities")
@Builder
@Entity
@Table(name = "book")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String title;
    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library", nullable = false)
    private LibraryEntity libraryEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "bookEntity", orphanRemoval = true)
    @Builder.Default
    private Set<AuthorEntity> authorEntities = new HashSet<>();
}
