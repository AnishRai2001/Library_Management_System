package com.jsp.Library_Management_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Library_Management_System.Entity.Book;

public interface BookRepository  extends JpaRepository<Book, Integer>{
	  List<Book> findByGenre(String genre);

}
