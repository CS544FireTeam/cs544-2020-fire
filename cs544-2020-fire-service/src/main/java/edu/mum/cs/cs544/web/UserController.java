package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.model.User;
import edu.mum.cs.cs544.service.student.IStudentService;
import edu.mum.cs.cs544.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private IUserService userService;
    
    @Autowired
    private IStudentService studentService;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    @GetMapping(value = "api/users")
    public List<User> getAllUser(){
        return this.userService.findAll();
    }
    
    @PostMapping(value = "/register")
    public String addStudent(@RequestBody Student user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
    	this.studentService.save(user);
    	return "success";
    }

    @GetMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable Integer id){
        return this.userService.findById(id);
    }

    @PostMapping(value = "api/users")
    public User saveUser(@RequestBody @Valid User user){
        return this.userService.save(user);
    }

    @PutMapping(value = "api/users/{id}")
    public User updateUser(@RequestBody @Valid User user){
        return this.userService.save(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable Integer id){
         this.userService.deleteById(id);
         return "success";
    }
}
