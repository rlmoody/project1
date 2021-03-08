package com.revature.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private HttpServletRequest req;

	@Autowired
	private UserDAO userDAO;
	
	public List<User> findAll() {
		return userDAO.findAll();
	}
	
	public User findById(int id) {
		return userDAO.findById(id)
				.orElseThrow( () -> new UserNotFoundException("No user found with id " + id));
	}
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username)
				.orElseThrow( () -> new UserNotFoundException("No user found with username " + username));
	}
	
	public User insert(User u) {
		if(u.getId() != 0) {
			throw new RuntimeException("User id must be zero");
		}
		
		userDAO.save(u);
		
		return u;
	}
	
	public boolean delete(int id) {
		if(!userDAO.existsById(id)) {
			return false;
		}
		
		userDAO.deleteById(id);
		
		return true;
	}
	
	public User update(User u) {
		if(!userDAO.existsById(u.getId())) {
			throw new RuntimeException("User must already exist to update");
		}
		
		userDAO.save(u);
		
//		HttpSession session = req.getSession(false);
		
//		User sessionUser = (User) session.getAttribute("currentUser");
	
//		if(sessionUser.getId() == u.getId()) {
//			session.setAttribute("currentUser", u);
//		}
		
		return u;
	
	}
}

