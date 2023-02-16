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
import com.librarymanagementsystem.dto.StudentDTO;
import com.librarymanagementsystem.exception.BookNotFoundException;
import com.librarymanagementsystem.exception.StudentNotFound;
import com.librarymanagementsystem.serviceimpl.BookServiceImpl;
import com.librarymanagementsystem.serviceimpl.StudentServiceimpl;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	StudentServiceimpl studentserviceimpl;
	@PostMapping("/student")
	public ResponseEntity<Student>saveStudent(@RequestBody @Valid StudentDTO studentDTO)
	{
	try{
	    Student student =studentserviceimpl.saveStudent(studentDTO);
	    if(student!=null)
	    {
	        return new ResponseEntity<Student>(student,HttpStatus.CREATED);
	    }
	}
	catch(Exception ex)
	{
	    throw new StudentNotFound("unable to add");
	}
	return new ResponseEntity<Student>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/students/{id}") ResponseEntity<Student> getStudentById(@PathVariable("id")int id)
    {
			try{
	    Student student =studentserviceimpl.getStudentById(id);
	    if(student!=null){
	        return new ResponseEntity<Student>(student,HttpStatus.FOUND);
	    }
	}
	catch(Exception ex)
	{
	    throw new StudentNotFound("NO BOOK FIND WITH ID"+id+"Found");
	}
	return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
	}
    
			
	@DeleteMapping("/student/delete/{id}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("id")int id)
	{
	try{
	    String student=studentserviceimpl.deleteStudent(id);
	    if(student!=null){
	        return new ResponseEntity<String>(student,HttpStatus.ACCEPTED);
	    }
	}
	catch(Exception ex)
	{
	    throw new StudentNotFound("unable to delete");
	}
	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
	}
		
	  @PutMapping("/student/update/{id}")
	 ResponseEntity<Student> UpdateStudentById(@RequestBody StudentDTO studentDTO,@PathVariable int id)
	{
		try{
	    Student student=studentserviceimpl.updateStudent(studentDTO, id);
	    if(student!=null){
	        return new ResponseEntity<Student>(student,HttpStatus.ACCEPTED);
	    }
	}
	catch(Exception ex)
	{
	    throw new StudentNotFound("unable to update");
	}
	return new ResponseEntity<Student>(HttpStatus.NOT_MODIFIED);
	}
	@GetMapping("/getstudents")
	  public ResponseEntity<List<Student>> getAllStudents()
	  {
		  return new ResponseEntity<>(studentserviceimpl.getAll(),HttpStatus.OK);
	  }
	}
