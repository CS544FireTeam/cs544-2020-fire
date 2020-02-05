package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Session;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface SessionService {

    List<Session> getAll(Sort sort);

    Optional<Session> getById(int id);

    Session create(Session loc);

    Session update(Session loc);

    void remove(int id);
}
