package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.TimeSlot;
import edu.mum.cs.cs544.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/time-slots")
public class TimeSlotController {

    @Autowired
    public TimeSlotService timeSlotService;

    @GetMapping
    public ResponseEntity<List<TimeSlot>> findAll() {
        return ResponseEntity.ok(timeSlotService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<TimeSlot> create(@Valid @RequestBody TimeSlot loc) {
        return ResponseEntity.ok(timeSlotService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlot> findById(@PathVariable int id) {
        Optional<TimeSlot> timeSlotOptional = timeSlotService.getById(id);
        if (!timeSlotOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(timeSlotOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSlot> update(@PathVariable int id, @Valid @RequestBody TimeSlot loc) {
        if (!timeSlotService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(timeSlotService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!timeSlotService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        timeSlotService.remove(id);

        return ResponseEntity.ok().build();
    }
}
