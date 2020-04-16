package com.example.librarydemo.persitence.repository;

import com.example.librarydemo.persitence.entity.LibraryEntity;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<LibraryEntity, String> {
}
