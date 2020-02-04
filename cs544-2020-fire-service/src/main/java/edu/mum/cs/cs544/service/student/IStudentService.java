package edu.mum.cs.cs544.service.student;

import edu.mum.cs.cs544.model.Student;

import java.util.List;

public interface IStudentService {

    public List<Student> findAll();

    public Student findById(Integer id);

    public Student save(Student student);

    public Student update(Student student);

    public boolean delete(Student student);

    public boolean delete(Integer id);
}
