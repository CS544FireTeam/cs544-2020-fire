package edu.mum.cs.cs544.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.cs544.model.TimeSlot;
import edu.mum.cs.cs544.service.TimeslotService;

@RestController
@RequestMapping("/api/timeslots")
public class TimeslotController {
	
	@Autowired
    private TimeslotService tsService;

	@GetMapping
    public ResponseEntity<List<TimeSlot>> findAll() {
        return ResponseEntity.ok(tsService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<TimeSlot> create(@Valid @RequestBody TimeSlot loc) {
        return ResponseEntity.ok(tsService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeSlot> findById(@PathVariable int id) {
        Optional<TimeSlot> loc = tsService.getById(id);
        if (!loc.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(loc.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeSlot> update(@PathVariable int id, @Valid @RequestBody TimeSlot loc) {
        if (!tsService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tsService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!tsService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        tsService.remove(id);

        return ResponseEntity.ok().build();
    }
}
