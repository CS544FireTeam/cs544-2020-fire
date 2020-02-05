package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Admin;
import edu.mum.cs.cs544.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    public AdminService adminService;

    @GetMapping
    public ResponseEntity<List<Admin>> findAll() {
        return ResponseEntity.ok(adminService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Admin> create(@Valid @RequestBody Admin loc) {
        return ResponseEntity.ok(adminService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> findById(@PathVariable int id) {
        Optional<Admin> adminOptional = adminService.getById(id);
        if (!adminOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(adminOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> update(@PathVariable int id, @Valid @RequestBody Admin loc) {
        if (!adminService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(adminService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!adminService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        adminService.remove(id);

        return ResponseEntity.ok().build();
    }
}
