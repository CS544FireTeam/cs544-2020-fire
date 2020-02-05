package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Student;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAll(Sort sort);

    Optional<Student> getById(int id);

    Student create(Student loc);

    Student update(Student loc);

    void remove(int id);
}
