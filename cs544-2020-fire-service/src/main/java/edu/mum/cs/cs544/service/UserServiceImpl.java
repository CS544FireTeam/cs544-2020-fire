package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.UserRepository;
import edu.mum.cs.cs544.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "username");
        }
        return userRepository.findAll(sort);
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User create(User loc) {
        return userRepository.save(loc);

    }

    @Override
    public User update(User loc) {
        return userRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
	}
}
