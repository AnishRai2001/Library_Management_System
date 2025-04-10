package com.jsp.Library_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Library_Management_System.Dao.BookDao;
import com.jsp.Library_Management_System.Dao.LoanDao;
import com.jsp.Library_Management_System.Entity.Book;
import com.jsp.Library_Management_System.Entity.Loan;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@Service
public class LoanService {
	@Autowired
	private LoanDao loanDao ;
	
	public ResponseEntity<ResponseStructure<Loan>> saveLoan(Loan loan) {
		Loan receivedLoan = loanDao.saveLoan(loan);
		
		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedLoan);

		return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.CREATED);
	}
			
	public ResponseEntity<ResponseStructure<List<Loan>>> showDetail() {
		List<Loan> list = loanDao.showDetails();

		ResponseStructure<List<Loan>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("SUCCESS");
		structure.setData(list);

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	

	public ResponseEntity<ResponseStructure<Loan>> findById(int id) {
		Optional<Loan> opt = loanDao.findById(id);

		ResponseStructure<Loan> response = new ResponseStructure<>();
		if (opt.isPresent()) {
		Loan loan = opt.get();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(loan);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("Author not found");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Loan>> UpdateBook(Loan loan) {
		Loan receivedloan = loanDao.saveLoan(loan);

		ResponseStructure<Loan> structure = new ResponseStructure<Loan>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedloan);
		
		return new ResponseEntity<ResponseStructure<Loan>>(structure, HttpStatus.CREATED);
		}
	
	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(int id) {
		Optional<Loan>opt=loanDao.findById(id);
		
			

			ResponseStructure<Loan> response = new ResponseStructure<>();
			if (opt.isPresent()) {
			Loan loan = opt.get();
				loanDao.deleteLoanById(id);
				
				response.setStatusCode(HttpStatus.OK.value());
				response.setMessage("Book deleted successfully");
				response.setData(null);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
				response.setMessage("Author not found");
				response.setData(null);
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
	
		}
}

