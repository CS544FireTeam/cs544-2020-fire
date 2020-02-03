package edu.mum.cs.cs544.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs544.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
