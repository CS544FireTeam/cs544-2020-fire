package edu.mum.cs.cs544.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;

import edu.mum.cs.cs544.model.TimeSlot;

public interface TimeslotService {
	
	List<TimeSlot> getAll(Sort sort);
	Optional<TimeSlot> getById(int id);
	TimeSlot create(TimeSlot ts);
	TimeSlot update(TimeSlot ts);
	void remove(int id);
}
