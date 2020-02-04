package edu.mum.cs.cs544.service.course;

import edu.mum.cs.cs544.dao.CourseRepository;
import edu.mum.cs.cs544.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        Optional<Course> course = this.courseRepository.findById(id);
        if(course.isPresent()) return course.get();
        else return null;
    }

    @Override
    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public boolean delete(Course course) {
        this.courseRepository.delete(course);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        this.courseRepository.deleteById(id);
        return true;
    }

}
