package edu.mum.cs.cs544.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs544.dao.AdminRepository;
import edu.mum.cs.cs544.model.Admin;

@RestController
public class UserController {
	
//	@Autowired
//    private UserService userService;

	@GetMapping("/users/admin")
	public List<Admin> getAllAdmin() {
		return null;
	}
}
