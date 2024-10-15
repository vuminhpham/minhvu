package com.example.demo7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo7.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
