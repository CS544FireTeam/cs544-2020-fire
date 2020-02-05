package edu.mum.cs.cs544.service;

import edu.mum.cs.cs544.dao.StudentRepository;
import edu.mum.cs.cs544.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAll(Sort sort) {
        if (sort == null) {
            sort = Sort.by(Direction.ASC, "username");
        }
        return studentRepository.findAll(sort);
    }

    @Override
    public Optional<Student> getById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student create(Student loc) {
        return studentRepository.save(loc);

    }

    @Override
    public Student update(Student loc) {
        return studentRepository.save(loc);
    }

    @Override
    public void remove(int id) {
        studentRepository.deleteById(id);
	}
}
