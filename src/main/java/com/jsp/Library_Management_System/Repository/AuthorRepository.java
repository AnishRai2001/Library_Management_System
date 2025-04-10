package com.jsp.Library_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Library_Management_System.Entity.Author;

public interface AuthorRepository  extends JpaRepository<Author, Integer>{

}
