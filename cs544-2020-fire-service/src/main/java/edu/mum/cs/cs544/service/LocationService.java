package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.Location;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface LocationService {

    List<Location> getAll(Sort sort);

    Optional<Location> getById(int id);

    Location create(Location loc);

    Location update(Location loc);

    void remove(int id);
}
