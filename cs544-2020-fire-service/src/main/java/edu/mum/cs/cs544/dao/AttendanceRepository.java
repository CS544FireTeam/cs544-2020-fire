package edu.mum.cs.cs544.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs544.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    @Query("select distinct a " +
            "from Attendance a join Session s on a.timeSlot.id = s.timeSlot.id " +
            "where (:studentId IS NULL OR a.student.id = :studentId) and " +
            "(:courseOfferingId IS NULL OR s.courseOffering.id = :courseOfferingId) and " +
            "(:courseId IS NULL OR s.courseOffering.course.id = :courseId)")
    List<Attendance> getAttendancesByAttendanceSearchRequest(@Param("studentId") Integer studentId, @Param("courseId") Integer courseId, @Param("courseOfferingId") Integer courseOfferingId);
}
