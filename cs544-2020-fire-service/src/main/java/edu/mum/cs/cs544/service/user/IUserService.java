package edu.mum.cs.cs544.service.user;

import edu.mum.cs.cs544.model.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User findById(Integer id);

    public User save(User user);

    public User update(User user);

    public boolean delete(User user);

    public boolean delete(Integer id);
}
