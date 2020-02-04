package edu.mum.cs.cs544.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.dao.LocationRepository;
import edu.mum.cs.cs544.model.Location;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	LocationRepository locRepo;

	@Override
	public List<Location> getAll(Sort sort) {
		if (sort == null) {
			sort = Sort.by(Direction.ASC, "description");
		}
		return locRepo.findAll(sort);
	}

	@Override
	public Optional<Location> getById(int id) {
		return locRepo.findById(id);
	}

	@Override
	public Location create(Location loc) {
		return locRepo.save(loc);
		
	}

	@Override
	public Location update(Location loc) {
		return locRepo.save(loc);
	}

	@Override
	public void remove(int id) {
		locRepo.deleteById(id);
	}
	
	

}
