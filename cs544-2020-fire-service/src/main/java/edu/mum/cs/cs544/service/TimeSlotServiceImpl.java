package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.TimeSlotRepository;
import edu.mum.cs.cs544.model.TimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TimeSlotServiceImpl implements TimeSlotService {

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Override
    public List<TimeSlot> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "description");
        }
        return timeSlotRepository.findAll(sort);
    }

    @Override
    public Optional<TimeSlot> getById(int id) {
        return timeSlotRepository.findById(id);
    }

    @Override
    public TimeSlot create(TimeSlot loc) {
        return timeSlotRepository.save(loc);

    }

    @Override
    public TimeSlot update(TimeSlot loc) {
        return timeSlotRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        timeSlotRepository.deleteById(id);
	}
}
