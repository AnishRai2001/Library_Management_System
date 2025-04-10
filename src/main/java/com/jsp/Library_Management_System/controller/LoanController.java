package com.jsp.Library_Management_System.controller;

import java.util.List;

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

import com.jsp.Library_Management_System.Entity.Book;
import com.jsp.Library_Management_System.Entity.Loan;
import com.jsp.Library_Management_System.Service.BookService;
import com.jsp.Library_Management_System.Service.LoanService;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@RequestMapping("/loan")
@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Loan>>saveBook(@RequestBody Loan loan){
		return loanService.saveLoan(loan);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Loan>>> showDetails() {
		return loanService.showDetail();

	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> findStudentById(@PathVariable int id) {
		return loanService.findById(id);

	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Loan>> UpdateLoan(@RequestBody Loan loan){
		return loanService.saveLoan(loan);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(@PathVariable int id){
		return loanService.deleteLoanById(id);
	}


}



