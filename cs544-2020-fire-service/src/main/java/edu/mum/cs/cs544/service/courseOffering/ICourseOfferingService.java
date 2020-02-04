package edu.mum.cs.cs544.service.courseOffering;

import edu.mum.cs.cs544.model.CourseOffering;

import java.util.List;

public interface ICourseOfferingService {

    public List<CourseOffering> findAll();

    public CourseOffering findById(Integer id);

    public CourseOffering save(CourseOffering courseOffering);

    public CourseOffering update(CourseOffering courseOffering);

    public boolean delete(CourseOffering courseOffering);

    public boolean delete(Integer id);

}
