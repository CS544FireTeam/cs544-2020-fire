package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student loc) {
        return ResponseEntity.ok(studentService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) {
        Optional<Student> studentOptional = studentService.getById(id);
        if (!studentOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(studentOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @Valid @RequestBody Student loc) {
        if (!studentService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!studentService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        studentService.remove(id);

        return ResponseEntity.ok().build();
    }
}
