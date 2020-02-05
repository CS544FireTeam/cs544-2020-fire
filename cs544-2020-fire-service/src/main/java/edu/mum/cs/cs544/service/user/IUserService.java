package edu.mum.cs.cs544.service.user;

import edu.mum.cs.cs544.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserService extends JpaRepository<User, Integer>{

//    public List<User> findAll();
//
//    public User findById(Integer id);
//
//    public User save(User user);
//
//    public User update(User user);
//
//    public boolean delete(User user);
//
//    public boolean delete(Integer id);
}
