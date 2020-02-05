package edu.mum.cs.cs544.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs544.model.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{
	
//	@Query("select distinct p from Attendance p join fetch p.student join fetch p.location join fetch p.timeslot")
//	List<Attendance> findAllAttendance(Sort sort);

}
