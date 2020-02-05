package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.User;
import edu.mum.cs.cs544.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUser(){
        return this.userService.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public User getUser(@PathVariable Integer id){
        return this.userService.findById(id);
    }

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody @Valid User user){
        return this.userService.save(user);
    }

    @PutMapping(value = "/users/{id}")
    public User updateUser(@RequestBody @Valid User user){
        return this.userService.save(user);
    }

    @DeleteMapping(value = "/users/{id}")
    public boolean deleteUser(@PathVariable Integer id){
        return this.userService.delete(id);
    }
}
