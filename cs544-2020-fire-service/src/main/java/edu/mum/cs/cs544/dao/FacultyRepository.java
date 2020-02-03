package edu.mum.cs.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs544.model.Faculty;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

}
