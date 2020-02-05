package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.model.TimeSlot;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface TimeSlotService {

    List<TimeSlot> getAll(Sort sort);

    Optional<TimeSlot> getById(int id);

    TimeSlot create(TimeSlot loc);

    TimeSlot update(TimeSlot loc);

    void remove(int id);
}
