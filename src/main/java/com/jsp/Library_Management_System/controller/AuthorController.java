package com.jsp.Library_Management_System.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.jsp.Library_Management_System.Service.AuthorService;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Author>> saveAuthor(@RequestBody Author author) {
		return authorService.saveAuthor(author);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Author>>> showDetails() {
		return authorService.showDetail();

	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Author>> findStudentById(@PathVariable int id) {
		return authorService.findById(id);

	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Author>> saveAuthor1(@RequestBody Author Author){
		return authorService.saveAuthor1(Author);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(@PathVariable int id){
		return authorService.deleteAuthor(id);
	}
}
