package edu.mum.cs.cs544.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.dao.TimeslotRepository;
import edu.mum.cs.cs544.model.TimeSlot;

@Service
@Transactional
public class TimeslotServiceImpl implements TimeslotService{
	
	@Autowired
	TimeslotRepository locRepo;

	@Override
	public List<TimeSlot> getAll(Sort sort) {
		if (sort == null) {
			sort = Sort.by(Direction.ASC, "description");
		}
		return locRepo.findAll(sort);
	}

	@Override
	public Optional<TimeSlot> getById(int id) {
		return locRepo.findById(id);
	}

	@Override
	public TimeSlot create(TimeSlot ts) {
		return locRepo.save(ts);
		
	}

	@Override
	public TimeSlot update(TimeSlot ts) {
		return locRepo.save(ts);
	}

	@Override
	public void remove(int id) {
		locRepo.deleteById(id);
	}
	
	

}
