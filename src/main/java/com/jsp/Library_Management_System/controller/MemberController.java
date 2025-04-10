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

import com.jsp.Library_Management_System.Entity.Loan;
import com.jsp.Library_Management_System.Entity.Member;
import com.jsp.Library_Management_System.Service.LoanService;
import com.jsp.Library_Management_System.Service.MemberService;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@RequestMapping("/member")
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Member>>saveMember(@RequestBody Member member){
		return memberService.saveMember(member);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Member>>> showDetails() {
		return memberService.showDetail();

	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Member>> findStudentById(@PathVariable int id) {
		return memberService.findById(id);

	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Member>> UpdateLoan(@RequestBody Member member){
		return memberService.saveMember(member);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Loan>> deleteLoan(@PathVariable int id){
		return memberService.deleteLoanById(id);
	}


}




