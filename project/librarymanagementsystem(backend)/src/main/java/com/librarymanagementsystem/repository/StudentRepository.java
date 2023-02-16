package com.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.librarymanagementsystem.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
