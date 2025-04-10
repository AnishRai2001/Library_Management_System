package com.jsp.Library_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Library_Management_System.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
