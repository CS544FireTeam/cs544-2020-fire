package edu.mum.cs.cs544.service.course;

import edu.mum.cs.cs544.model.Course;

import java.util.List;

public interface ICourseService {

    public List<Course> findAll();

    public Course findById(Integer id);

    public Course save(Course course);

    public Course update(Course course);

    public boolean delete(Course course);

    public boolean delete(Integer id);
}
