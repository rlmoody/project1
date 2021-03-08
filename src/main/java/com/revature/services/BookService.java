package com.revature.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.BookNotFoundException;
import com.revature.models.Book;
import com.revature.repositories.BookDAO;

@Service
public class BookService {

	@Autowired
	private HttpServletRequest req;

	@Autowired
	private BookDAO bookDAO;
	
	public List<Book> findAll() {
		return bookDAO.findAll();
	}
	
	public Book findById(int id) {
		return bookDAO.findById(id)
				.orElseThrow( () -> new BookNotFoundException("No book found with id " + id));
	}
	
	public Book findByTitle(String title) {
		return bookDAO.findByTitle(title)
				.orElseThrow( () -> new BookNotFoundException("No book found with username " + title));
	}
	
	public Book insert(Book b) {
		if(b.getId() != 0) {
			throw new RuntimeException("Book id must be zero");
		}
		
		bookDAO.save(b);
		
		return b;
	}
	
	public boolean delete(int id) {
		if(bookDAO.existsById(id)) {
			return false;
		}
		
		bookDAO.deleteById(id);
		
		return true;
	}
	
	public Book update(Book b) {
		if(!bookDAO.existsById(b.getId())) {
			throw new RuntimeException("Book must already exist to update");
		}
		
		bookDAO.save(b);
		
		HttpSession session = req.getSession(false);
		
		Book sessionUser = (Book) session.getAttribute("currentBook");
	
		if(sessionUser.getId() == b.getId()) {
			session.setAttribute("currentUser", b);
		}
		
		return b;
	
	}

}
