package com.example.demo.repository;

import com.example.demo.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    Optional<Book> findById(UUID uuid);
}
