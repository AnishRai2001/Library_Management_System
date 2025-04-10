package com.jsp.Library_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.jsp.Library_Management_System.Dao.AuthorDao;
import com.jsp.Library_Management_System.Entity.Author;
import com.jsp.Library_Management_System.Repository.AuthorRepository;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@Service
public class AuthorService {
	@Autowired
	private AuthorDao authorDao;

	public ResponseEntity<ResponseStructure<Author>> saveAuthor(Author author) {
		Author receivedAuthor = authorDao.saveAuthor(author);

		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedAuthor);

		return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Author>>> showDetail() {
		List<Author> list = authorDao.showDetails();

		ResponseStructure<List<Author>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("SUCCESS");
		structure.setData(list);

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Author>> findById(int id) {
		Optional<Author> opt = authorDao.findById(id);

		ResponseStructure<Author> response = new ResponseStructure<>();
		if (opt.isPresent()) {
			Author author = opt.get();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(author);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("Author not found");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Author>> saveAuthor1(Author author) {
		Author receivedAuthor = authorDao.saveAuthor(author);

		ResponseStructure<Author> structure = new ResponseStructure<Author>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedAuthor);

		return new ResponseEntity<ResponseStructure<Author>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Author>> deleteAuthor(int id) {
		Optional<Author>opt=authorDao.findById(id);
		
			

			ResponseStructure<Author> response = new ResponseStructure<>();
			if (opt.isPresent()) {
				Author author = opt.get();
				authorDao.deleteAuthor(id);
				
				response.setStatusCode(HttpStatus.OK.value());
				response.setMessage("Author deleted successfully");
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
