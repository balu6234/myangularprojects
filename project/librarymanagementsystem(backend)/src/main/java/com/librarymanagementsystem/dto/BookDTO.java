package com.librarymanagementsystem.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.librarymanagementsystem.Entity.Book;
import com.librarymanagementsystem.Entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {
 @NotBlank(message="empty not allowed")
 @NotNull(message="null value not allowed")
 private int id;
 @Size(min=3,max=15,message="name must be in range 3-15 characters")
 private String bookName;
 @Size(min=3,max=15,message="name must be in range 3-15 characters")
 private String bookAuthor;
 @Min(value=100,message="invalid price")
 @Max(value=1000,message="invalid price")
 private String bookPrice;
 @NotNull(message="null not allowed")
 private String bookPublication;
 }
