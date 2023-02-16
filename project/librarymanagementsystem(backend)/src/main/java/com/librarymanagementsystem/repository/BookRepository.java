package com.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanagementsystem.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
