package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.service.CourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course-offerings")
public class CourseOfferingController {

    @Autowired
    public CourseOfferingService courseOfferingService;

    @GetMapping
    public ResponseEntity<List<CourseOffering>> findAll() {
        return ResponseEntity.ok(courseOfferingService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<CourseOffering> create(@Valid @RequestBody CourseOffering loc) {
        return ResponseEntity.ok(courseOfferingService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseOffering> findById(@PathVariable int id) {
        Optional<CourseOffering> courseOfferingOptional = courseOfferingService.getById(id);
        if (!courseOfferingOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(courseOfferingOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseOffering> update(@PathVariable int id, @Valid @RequestBody CourseOffering loc) {
        if (!courseOfferingService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(courseOfferingService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!courseOfferingService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        courseOfferingService.remove(id);

        return ResponseEntity.ok().build();
    }
}
