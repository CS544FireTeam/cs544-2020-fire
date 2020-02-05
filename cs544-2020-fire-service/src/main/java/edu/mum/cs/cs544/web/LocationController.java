package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    public LocationService locationService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Location>> findAll() {
        return ResponseEntity.ok(locationService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Location> create(@Valid @RequestBody Location loc) {
        return ResponseEntity.ok(locationService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> findById(@PathVariable int id) {
        Optional<Location> locationOptional = locationService.getById(id);
        if (!locationOptional.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(locationOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> update(@PathVariable int id, @Valid @RequestBody Location loc) {
        if (!locationService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(locationService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!locationService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        locationService.remove(id);

        return ResponseEntity.ok().build();
    }
}
