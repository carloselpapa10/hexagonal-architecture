package com.example.librarydemo.persitence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "bookEntities")
@Builder
@Entity
@Table(name = "library")
public class LibraryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String location;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "libraryEntity", orphanRemoval = true)
    @Builder.Default
    private Set<BookEntity> bookEntities = new HashSet<>();
}
