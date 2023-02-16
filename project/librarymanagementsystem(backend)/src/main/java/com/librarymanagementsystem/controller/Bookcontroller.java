package com.librarymanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.librarymanagementsystem.Entity.Book;
import com.librarymanagementsystem.Entity.Student;
import com.librarymanagementsystem.dto.BookDTO;
import com.librarymanagementsystem.exception.BookNotFoundException;
import com.librarymanagementsystem.exception.StudentNotFound;
import com.librarymanagementsystem.serviceimpl.BookServiceImpl;
import com.librarymanagementsystem.serviceimpl.StudentServiceimpl;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Bookcontroller {
	@Autowired
	BookServiceImpl bookservice;
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody @Valid BookDTO bookDTO)
	{
	try{
	    Book book =bookservice.saveBook(bookDTO);
	    if(book!=null)
	    {
	        return new ResponseEntity<Book>(book,HttpStatus.CREATED);
	    }
	}
	catch(Exception ex)
	{
	    throw new BookNotFoundException("unable to add");
	}
	return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/books/{id}") ResponseEntity<Book> getBookById(@PathVariable("id")int id)
    {
			try{
	    Book book =bookservice.getBookById(id);
	    if(book!=null){
	        return new ResponseEntity<Book>(book,HttpStatus.FOUND);
	    }
	}
	catch(Exception ex)
	{
	    throw new BookNotFoundException("NO BOOK FIND WITH ID"+id+"Found");
	}
	return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
	}
    
			
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBookById(@PathVariable("id")int id)
	{
	try{
	    String book=bookservice.deleteBookById(id);
	    if(book!=null){
	        return new ResponseEntity<String>(book,HttpStatus.ACCEPTED);
	    }
	}
	catch(Exception ex)
	{
	    throw new BookNotFoundException("unable to delete");
	}
	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
	}
		
	  @PutMapping("/book/update/{id}")
	 ResponseEntity<Book> UpdateBookById(@RequestBody BookDTO bookDTO,@PathVariable int id)
	{
		try{
	    Book book =bookservice.updateBook(bookDTO,id);
	    if(book!=null){
	        return new ResponseEntity<Book>(book,HttpStatus.ACCEPTED);
	    }
	}
	catch(Exception ex)
	{
	    throw new BookNotFoundException("unable to update");
	}
	return new ResponseEntity<Book>(HttpStatus.NOT_MODIFIED);
	}
	  @GetMapping("/getbooks")
	  public ResponseEntity<List<Book>> getAllBooks()
	  {
		  return new ResponseEntity<>(bookservice.getAll(),HttpStatus.OK);
	  }
	}
