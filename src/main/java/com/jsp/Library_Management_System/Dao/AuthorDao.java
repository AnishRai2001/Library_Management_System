package com.jsp.Library_Management_System.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Library_Management_System.Entity.Author;
import com.jsp.Library_Management_System.Repository.AuthorRepository;

@Repository
public class AuthorDao {

	@Autowired
	private AuthorRepository authorRepository ;
	 
	public Author saveAuthor(Author author) {
		return authorRepository.save(author) ;
	}
	
	
	public List<Author> showDetails(){
		return authorRepository.findAll();
	}
	public Optional<Author> findById(int id) {
		return authorRepository.findById(id);
	}
	public Author UpdateAuthor(Author author) {
		return authorRepository.save(author);
	}
	public boolean deleteAuthor(int id) {
        Optional<Author> authorOpt = authorRepository.findById(id);
        if (authorOpt.isPresent()) {
            // Deleting the author from the repository
            authorRepository.deleteById(id);
            return true;
        }
        return false;
    }
	
}

