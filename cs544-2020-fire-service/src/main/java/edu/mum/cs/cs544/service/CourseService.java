package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Course;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAll(Sort sort);

    Optional<Course> getById(int id);

    Course create(Course loc);

    Course update(Course loc);

    void remove(int id);
}
