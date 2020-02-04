package edu.mum.cs.cs544.service.user;

import edu.mum.cs.cs544.dao.UserRepository;
import edu.mum.cs.cs544.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()) return user.get();
        else return null;
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public boolean delete(User user) {
        this.userRepository.delete(user);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        this.userRepository.deleteById(id);
        return true;
    }

}