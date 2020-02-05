package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Faculty;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface FacultyService {

    List<Faculty> getAll(Sort sort);

    Optional<Faculty> getById(int id);

    Faculty create(Faculty loc);

    Faculty update(Faculty loc);

    void remove(int id);
}
