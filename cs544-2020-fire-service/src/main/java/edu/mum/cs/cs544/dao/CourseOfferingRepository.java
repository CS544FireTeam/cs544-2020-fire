package edu.mum.cs.cs544.dao;

import edu.mum.cs.cs544.model.CourseOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {
}
