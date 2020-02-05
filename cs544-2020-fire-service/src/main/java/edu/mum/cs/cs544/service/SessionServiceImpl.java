package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.SessionRepository;
import edu.mum.cs.cs544.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public List<Session> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "date");
        }
        return sessionRepository.findAll(sort);
    }

    @Override
    public Optional<Session> getById(int id) {
        return sessionRepository.findById(id);
    }

    @Override
    public Session create(Session loc) {
        return sessionRepository.save(loc);

    }

    @Override
    public Session update(Session loc) {
        return sessionRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        sessionRepository.deleteById(id);
	}
}
