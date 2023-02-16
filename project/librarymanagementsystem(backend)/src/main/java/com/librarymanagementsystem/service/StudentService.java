package com.librarymanagementsystem.service;

import java.util.List;

import com.librarymanagementsystem.Entity.Student;
import com.librarymanagementsystem.dto.StudentDTO; 

public interface StudentService {
   Student saveStudent(StudentDTO studentDTO);
   Student updateStudent(StudentDTO studentDTO,int id);
   List<Student> getAll();
   Student getStudentById(int id);
   String deleteStudent(int id);
}
