package com.librarymanagementsystem.service;

import java.util.List;

import com.librarymanagementsystem.Entity.Book;
import com.librarymanagementsystem.dto.BookDTO;

public interface BookService {
  Book saveBook(BookDTO bookDTO);
  Book updateBook(BookDTO bookDTO, int id);
  String deleteBookById(int id);
  List<Book> getAll();
  Book getBookById(int id);
}
