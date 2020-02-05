package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Session;
import edu.mum.cs.cs544.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    public SessionService sessionService;

    @GetMapping
    public ResponseEntity<List<Session>> findAll() {
        return ResponseEntity.ok(sessionService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Session> create(@Valid @RequestBody Session loc) {
        return ResponseEntity.ok(sessionService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> findById(@PathVariable int id) {
        Optional<Session> sessionOptional = sessionService.getById(id);
        if (!sessionOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(sessionOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> update(@PathVariable int id, @Valid @RequestBody Session loc) {
        if (!sessionService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sessionService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!sessionService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        sessionService.remove(id);

        return ResponseEntity.ok().build();
    }
}
