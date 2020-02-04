package edu.mum.cs.cs544.service.session;

import edu.mum.cs.cs544.dao.SessionRepository;
import edu.mum.cs.cs544.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SessionService implements ISessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> findAll() {
        return this.sessionRepository.findAll();
    }

    @Override
    public Session findById(Integer id) {
        Optional<Session> session = this.sessionRepository.findById(id);
        if(session.isPresent()) return session.get();
        else return null;
    }

    @Override
    public Session save(Session session) {
        return this.sessionRepository.save(session);
    }

    @Override
    public Session update(Session session) {
        return this.sessionRepository.save(session);
    }

    @Override
    public boolean delete(Session session) {
        this.sessionRepository.delete(session);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        this.sessionRepository.deleteById(id);
        return true;
    }

}
