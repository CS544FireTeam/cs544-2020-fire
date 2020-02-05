package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.CourseOffering;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CourseOfferingService {

    List<CourseOffering> getAll(Sort sort);

    Optional<CourseOffering> getById(int id);

    CourseOffering create(CourseOffering loc);

    CourseOffering update(CourseOffering loc);

    void remove(int id);
}
