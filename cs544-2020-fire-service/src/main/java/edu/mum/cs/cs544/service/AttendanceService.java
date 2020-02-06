package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dto.AttendanceSearchRequestDTO;
import edu.mum.cs.cs544.model.Attendance;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface AttendanceService {

    List<Attendance> getAll(Sort sort);

    Optional<Attendance> getById(int id);

    Attendance create(Attendance loc);

    Attendance update(Attendance loc);

    void remove(int id);

    List<Attendance> getAttendancesByAttendanceSearchRequest(AttendanceSearchRequestDTO studentId);
}
