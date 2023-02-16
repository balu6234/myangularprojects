package com.librarymanagementsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagementsystem.Entity.Book;
import com.librarymanagementsystem.Entity.Student;
import com.librarymanagementsystem.dto.BookDTO;
import com.librarymanagementsystem.repository.BookRepository;
import com.librarymanagementsystem.service.BookService;
@Service
public class BookServiceImpl implements BookService{
@Autowired
BookRepository bookrepository;

@Override
public Book saveBook(BookDTO bookDTO) {	
	Book book=Book.builder()
			.bookName(bookDTO.getBookName())
			.bookAuthor(bookDTO.getBookAuthor())
			.bookPrice(bookDTO.getBookPrice()).bookPublication(bookDTO.getBookPublication())
			.build();
	return bookrepository.save(book);
	
}
@Override
public Book updateBook(BookDTO bookDTO, int id) {
	Book book=bookrepository.findById(id).get();
	Book book1=Book.builder()
			.bookName(bookDTO.getBookName())
			.bookAuthor(bookDTO.getBookAuthor())
			.bookPrice(bookDTO.getBookPrice()).bookPublication(bookDTO.getBookPublication())
			.build();
	return bookrepository.save(book1);
}

@Override
public String deleteBookById(int id) {
	 bookrepository.deleteById(id);
	 return "deleted successfully";
	
}

@Override
public Book getBookById(int id) {
	return bookrepository.findById(id).get();
}
@Override
public List<Book> getAll() {
	return bookrepository.findAll();
}

}
