package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    public CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(courseService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Course> create(@Valid @RequestBody Course loc) {
        return ResponseEntity.ok(courseService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable int id) {
        Optional<Course> courseOptional = courseService.getById(id);
        if (!courseOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(courseOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable int id, @Valid @RequestBody Course loc) {
        if (!courseService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(courseService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!courseService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        courseService.remove(id);

        return ResponseEntity.ok().build();
    }
}
