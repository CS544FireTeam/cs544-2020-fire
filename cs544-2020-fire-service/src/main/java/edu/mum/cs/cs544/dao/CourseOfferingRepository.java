package edu.mum.cs.cs544.dao;

import edu.mum.cs.cs544.model.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {
    List<CourseOffering> findAllByFacultyIdAndCourseCode(Integer facultyId, String courseCode);
}
