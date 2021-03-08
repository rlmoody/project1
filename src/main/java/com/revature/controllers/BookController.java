package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Book;
import com.revature.services.BookService;

@RestController
@RequestMapping("/books")

public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		
		return ResponseEntity.ok(bookService.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable("id") int id) {
		//authorizationService.guardByUserId(id);
		
		return ResponseEntity.ok(bookService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Book> insert(@RequestBody Book b) {
		
		return ResponseEntity.accepted().body(bookService.insert(b));
	}
	
	@GetMapping("/{title}")
	public ResponseEntity<Book> findByTitle(@PathVariable("title") String title) {
	
		return ResponseEntity.ok(bookService.findByTitle(title));
	}
}
