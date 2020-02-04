package edu.mum.cs.cs544.dao;

import edu.mum.cs.cs544.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session , Integer> {
}
