package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.FacultyRepository;
import edu.mum.cs.cs544.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "username");
        }
        return facultyRepository.findAll(sort);
    }

    @Override
    public Optional<Faculty> getById(int id) {
        return facultyRepository.findById(id);
    }

    @Override
    public Faculty create(Faculty loc) {
        return facultyRepository.save(loc);

    }

    @Override
    public Faculty update(Faculty loc) {
        return facultyRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        facultyRepository.deleteById(id);
	}
}
