package com.jsp.Library_Management_System.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.Library_Management_System.Dao.AuthorDao;
import com.jsp.Library_Management_System.Dao.BookDao;
import com.jsp.Library_Management_System.Entity.Author;
import com.jsp.Library_Management_System.Entity.Book;
import com.jsp.Library_Management_System.Repository.BookRepository;
import com.jsp.Library_Management_System.dto.ResponseStructure;

@Service
public class BookService {
	@Autowired
	private BookDao bookDao ;
	
	public ResponseEntity<ResponseStructure<Book>> saveBook(Book book) {
		Book receivedBook = bookDao.saveBook(book);
		
		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedBook);

		return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.CREATED);
	}
			
	public ResponseEntity<ResponseStructure<List<Book>>> showDetail() {
		List<Book> list = bookDao.showDetails();

		ResponseStructure<List<Book>> structure = new ResponseStructure<>();
		structure.setStatusCode(HttpStatus.OK.value());
		structure.setMessage("SUCCESS");
		structure.setData(list);

		return new ResponseEntity<>(structure, HttpStatus.OK);
	}
	
	

	public ResponseEntity<ResponseStructure<Book>> findById(int id) {
		Optional<Book> opt = bookDao.findById(id);

		ResponseStructure<Book> response = new ResponseStructure<>();
		if (opt.isPresent()) {
		Book book = opt.get();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Success");
			response.setData(book);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage("Author not found");
			response.setData(null);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<ResponseStructure<Book>> UpdateBook(Book book) {
		Book receivedBook = bookDao.saveBook(book);

		ResponseStructure<Book> structure = new ResponseStructure<Book>();
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setMessage("SUCCESS");
		structure.setData(receivedBook);
		
		return new ResponseEntity<ResponseStructure<Book>>(structure, HttpStatus.CREATED);
		}
	
	public ResponseEntity<ResponseStructure<Book>> deleteBook(int id) {
		Optional<Book>opt=bookDao.findById(id);
		
			

			ResponseStructure<Book> response = new ResponseStructure<>();
			if (opt.isPresent()) {
				Book book = opt.get();
				bookDao.deleteBookById(id);
				
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
	public List<Book> getBooksByGenre(String genre) {
	    return bookDao.findBooksByGenre(genre);
	}
	
}


