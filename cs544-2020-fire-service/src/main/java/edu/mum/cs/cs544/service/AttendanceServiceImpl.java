package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.AttendanceRepository;
import edu.mum.cs.cs544.dto.AttendanceSearchRequestDTO;
import edu.mum.cs.cs544.model.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "attendedDate");
        }
        return attendanceRepository.findAll(sort);
    }

    @Override
    public Optional<Attendance> getById(int id) {
        return attendanceRepository.findById(id);
    }

    @Override
    public Attendance create(Attendance loc) {
        return attendanceRepository.save(loc);

    }

    @Override
    public Attendance update(Attendance loc) {
        return attendanceRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public List<Attendance> getAttendancesByAttendanceSearchRequest(AttendanceSearchRequestDTO asr) {
        return attendanceRepository.getAttendancesByAttendanceSearchRequest(asr.getStudentId(), asr.getCourseId(), asr.getCourseOfferingId());
    }
}
