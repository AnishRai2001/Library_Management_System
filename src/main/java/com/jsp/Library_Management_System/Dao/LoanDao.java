package com.jsp.Library_Management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Library_Management_System.Entity.Book;
import com.jsp.Library_Management_System.Entity.Loan;
import com.jsp.Library_Management_System.Repository.BookRepository;
import com.jsp.Library_Management_System.Repository.LoanRepository;
@Repository
public class LoanDao {
	@Autowired
	private LoanRepository loanRepository ;
	
	public Loan saveLoan(Loan loan) {
		return loanRepository.save(loan) ;
	}
	
	
	public List<Loan> showDetails(){
		return loanRepository.findAll();
	}
	public Optional<Loan> findById(int id) {
		return loanRepository.findById(id);
	}
	public Loan UpdatLoank(Loan loan) {
		return loanRepository.save(loan);
	}
	public Loan deleteLoanById(int id) {
		Optional<Loan> opt = loanRepository.findById(id) ;
		if(!opt.isEmpty()) {
		loanRepository.deleteById(id) ;
		return opt.get() ;
		}
		else {
		return null ;
		}
	}
}
