package com.revature.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.jboss.logging.MDC;
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

import com.revature.models.User;
import com.revature.services.UserService;


@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		MDC.clear();
		return ResponseEntity.ok(userService.findAll());
		
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		//authorizationService.guardByUserId(id);
		
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@GetMapping("username/{username}")
	public ResponseEntity<User> findByUsername(@PathVariable("username") String username) {
	
		return ResponseEntity.ok(userService.findByUsername(username));
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User u) {
		MDC.clear();
		return ResponseEntity.accepted().body(userService.insert(u));
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> update(@RequestBody User u) {
		MDC.clear();
		return ResponseEntity.accepted().body(userService.update(u));
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		MDC.clear();
		return ResponseEntity.ok(userService.delete(id));
	}
	
}
