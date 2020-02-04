package edu.mum.cs.cs544.service.faculty;

import edu.mum.cs.cs544.dao.FacultyRepository;
import edu.mum.cs.cs544.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FacultyService implements IFacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public List<Faculty> findAll() {
        return this.facultyRepository.findAll();
    }

    @Override
    public Faculty findById(Integer id) {
        Optional<Faculty> faculty = this.facultyRepository.findById(id);
        if(faculty.isPresent()) return faculty.get();
        else return null;
    }

    @Override
    public Faculty save(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    @Override
    public Faculty update(Faculty faculty) {
        return this.facultyRepository.save(faculty);
    }

    @Override
    public boolean delete(Faculty faculty) {
        this.facultyRepository.delete(faculty);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        this.facultyRepository.deleteById(id);
        return true;
    }

}
