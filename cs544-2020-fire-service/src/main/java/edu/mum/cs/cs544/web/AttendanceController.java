package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.dto.AttendanceSearchRequestDTO;
import edu.mum.cs.cs544.model.Attendance;
import edu.mum.cs.cs544.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    public AttendanceService attendanceService;

    @GetMapping
    public ResponseEntity<List<Attendance>> findAll() {
        return ResponseEntity.ok(attendanceService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Attendance> create(@Valid @RequestBody Attendance loc) {
        return ResponseEntity.ok(attendanceService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> findById(@PathVariable int id) {
        Optional<Attendance> attendanceOptional = attendanceService.getById(id);
        if (!attendanceOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(attendanceOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> update(@PathVariable int id, @Valid @RequestBody Attendance loc) {
        if (!attendanceService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(attendanceService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!attendanceService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        attendanceService.remove(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Attendance>> findAll(@RequestBody AttendanceSearchRequestDTO attendanceSearch) {
        return ResponseEntity.ok(attendanceService.getAttendancesByAttendanceSearchRequest(attendanceSearch));
    }

}
