package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.CourseRepository;
import edu.mum.cs.cs544.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "code");
        }
        return courseRepository.findAll(sort);
    }

    @Override
    public Optional<Course> getById(int id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course create(Course loc) {
        return courseRepository.save(loc);

    }

    @Override
    public Course update(Course loc) {
        return courseRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        courseRepository.deleteById(id);
	}
}
