package com.jsp.Library_Management_System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Library_Management_System.Entity.Author;
import com.jsp.Library_Management_System.Entity.Book;
import com.jsp.Library_Management_System.Service.BookService;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@RequestMapping("/book")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Book>>saveBook(@RequestBody Book book){
		return bookService.saveBook(book);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Book>>> showDetails() {
		return bookService.showDetail();

	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> findStudentById(@PathVariable int id) {
		return bookService.findById(id);

	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Book>> UpdateBook(@RequestBody Book book){
		return bookService.UpdateBook(book);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Book>> deleteBook(@PathVariable int id){
		return bookService.deleteBook(id);
	}
	@GetMapping("/genre/{genre}")
	public ResponseEntity<ResponseStructure<List<Book>>> getBooksByGenre(@PathVariable String genre) {
	    List<Book> books = bookService.getBooksByGenre(genre);

	    ResponseStructure<List<Book>> structure = new ResponseStructure<>();
	    structure.setStatusCode(HttpStatus.OK.value());
	    structure.setMessage("SUCCESS");
	    structure.setData(books);

	    return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	 


}
