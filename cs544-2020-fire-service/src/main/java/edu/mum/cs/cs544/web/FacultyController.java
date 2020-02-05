package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Faculty;
import edu.mum.cs.cs544.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {

    @Autowired
    public FacultyService facultyService;

    @GetMapping
    public ResponseEntity<List<Faculty>> findAll() {
        return ResponseEntity.ok(facultyService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Faculty> create(@Valid @RequestBody Faculty loc) {
        return ResponseEntity.ok(facultyService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> findById(@PathVariable int id) {
        Optional<Faculty> facultyOptional = facultyService.getById(id);
        if (!facultyOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(facultyOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> update(@PathVariable int id, @Valid @RequestBody Faculty loc) {
        if (!facultyService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(facultyService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!facultyService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        facultyService.remove(id);

        return ResponseEntity.ok().build();
    }
}
