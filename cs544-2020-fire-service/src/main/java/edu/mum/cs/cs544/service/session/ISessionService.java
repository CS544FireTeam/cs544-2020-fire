package edu.mum.cs.cs544.service.session;

import edu.mum.cs.cs544.model.Session;

import java.util.List;

public interface ISessionService {

    public List<Session> findAll();

    public Session findById(Integer id);

    public Session save(Session session);

    public Session update(Session session);

    public boolean delete(Session session);

    public boolean delete(Integer id);

}
