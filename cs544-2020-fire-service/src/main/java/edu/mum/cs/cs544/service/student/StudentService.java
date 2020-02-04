package edu.mum.cs.cs544.service.student;

import edu.mum.cs.cs544.dao.StudentRepository;
import edu.mum.cs.cs544.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        Optional<Student> student = this.studentRepository.findById(id);
        if(student.isPresent()) return student.get();
        else return null;
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public boolean delete(Student student) {
        this.studentRepository.delete(student);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        this.studentRepository.deleteById(id);
        return true;
    }

}
