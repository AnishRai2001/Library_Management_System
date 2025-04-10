package com.jsp.Library_Management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Library_Management_System.Entity.Loan;
import com.jsp.Library_Management_System.Entity.Member;
import com.jsp.Library_Management_System.Repository.LoanRepository;
import com.jsp.Library_Management_System.Repository.MemberRepository;

@Repository
public class MemberDao {
	@Autowired
	private MemberRepository memberRepository ;
	
	public Member saveMember(Member member) {
		return memberRepository.save(member) ;
	}
	
	
	public List<Member> showDetails(){
		return memberRepository.findAll();
	}
	public Optional<Member> findById(int id) {
		return memberRepository.findById(id);
	}
	public Member UpdatLoan(Member member) {
		return memberRepository.save(member);
	}
	public Member deleteLoanById(int id) {
		Optional<Member> opt = memberRepository.findById(id) ;
		if(!opt.isEmpty()) {
		memberRepository.deleteById(id) ;
		return opt.get() ;
		}
		else {
		return null ;
		}
	}

}
