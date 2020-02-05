package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.User;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll(Sort sort);

    Optional<User> getById(int id);

    User create(User loc);

    User update(User loc);

    void remove(int id);
}
