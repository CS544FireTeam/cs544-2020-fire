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

import edu.mum.cs.cs544.model.Location;
import edu.mum.cs.cs544.service.LocationService;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
	
	@Autowired
    private LocationService locService;

	@GetMapping
    public ResponseEntity<List<Location>> findAll() {
        return ResponseEntity.ok(locService.getAll(null));
    }

    @PostMapping
    public ResponseEntity<Location> create(@Valid @RequestBody Location loc) {
        return ResponseEntity.ok(locService.create(loc));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> findById(@PathVariable int id) {
        Optional<Location> loc = locService.getById(id);
        if (!loc.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(loc.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> update(@PathVariable int id, @Valid @RequestBody Location loc) {
        if (!locService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(locService.update(loc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        if (!locService.getById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        locService.remove(id);

        return ResponseEntity.ok().build();
    }
}
