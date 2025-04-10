package com.jsp.Library_Management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Library_Management_System.Entity.Author;
import com.jsp.Library_Management_System.Entity.Book;
import com.jsp.Library_Management_System.Repository.AuthorRepository;
import com.jsp.Library_Management_System.Repository.BookRepository;

@Repository
public class BookDao {
	@Autowired
	private BookRepository bookRepository ;
	
	@Autowired
	private AuthorRepository authorRepository;
	public Book saveBook(Book book) {
		Book b=bookRepository.save(book);
		Integer aid=b.getAuthor().getId();
		Optional<Author>opt=authorRepository.findById(aid);
		Author a= opt.get();
		b.setAuthor(a);
		return b;
		}
	
	
	public List<Book> showDetails(){
		return bookRepository.findAll();
	}
	public Optional<Book> findById(int id) {
		return bookRepository.findById(id);
	}
	public Book UpdateBook(Book book) {
		return bookRepository.save(book);
	}
	public Book deleteBookById(int id) {
		Optional<Book> opt = bookRepository.findById(id) ;
		if(!opt.isEmpty()) {
		bookRepository.deleteById(id) ;
		return opt.get() ;
		}
		else {
		return null ;
		}
	}
	 public List<Book> findBooksByGenre(String genre) {
		 return bookRepository.findByGenre(genre);
	 }
}


