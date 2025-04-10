package com.jsp.Library_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Library_Management_System.Dao.LoanDao;
import com.jsp.Library_Management_System.Dao.MemberDao;
import com.jsp.Library_Management_System.Entity.Loan;
import com.jsp.Library_Management_System.Entity.Member;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@Service   
public class MemberService {

	@Autowired
	private MemberDao memberDao ;
	
	public ResponseEntity<ResponseStructure<Member>> saveMember(Member member) {
		Member receivedMember = memberDao.saveMember(member);
		
		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedMember);

		return new ResponseEntity<ResponseStructure<Member>>(HttpStatus.CREATED);
	}
			
	public ResponseEntity<ResponseStructure<List<Member>>> showDetail() {
		List<Member> list = memberDao.showDetails();

		ResponseStructure<List<Member>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("SUCCESS");
		structure.setData(list);

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	

	public ResponseEntity<ResponseStructure<Member>> findById(int id) {
		Optional<Member> opt = memberDao.findById(id);

		ResponseStructure<Member> response = new ResponseStructure<>();
		if (opt.isPresent()) {
			Member member = opt.get();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(member);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("Author not found");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Member>> UpdateBook(Member member) {
	Member receivedmember = memberDao.saveMember(member);

		ResponseStructure<Member> structure = new ResponseStructure<Member>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedmember);
		
		return new ResponseEntity<ResponseStructure<Member>>(structure, HttpStatus.CREATED);
		}
	
	public ResponseEntity<ResponseStructure<Loan>> deleteLoanById(int id) {
		Optional<Member>opt=memberDao.findById(id);
		
			

			ResponseStructure<Loan> response = new ResponseStructure<>();
			if (opt.isPresent()) {
				Member member = opt.get();
				memberDao.deleteLoanById(id);
				
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


