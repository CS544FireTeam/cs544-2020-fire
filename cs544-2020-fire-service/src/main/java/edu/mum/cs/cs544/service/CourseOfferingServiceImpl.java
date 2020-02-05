package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.CourseOfferingRepository;
import edu.mum.cs.cs544.model.CourseOffering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseOfferingServiceImpl implements CourseOfferingService {

    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Override
    public List<CourseOffering> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "startDate");
        }
        return courseOfferingRepository.findAll(sort);
    }

    @Override
    public Optional<CourseOffering> getById(int id) {
        return courseOfferingRepository.findById(id);
    }

    @Override
    public CourseOffering create(CourseOffering loc) {
        return courseOfferingRepository.save(loc);

    }

    @Override
    public CourseOffering update(CourseOffering loc) {
        return courseOfferingRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        courseOfferingRepository.deleteById(id);
	}
}
