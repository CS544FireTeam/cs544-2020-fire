package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(value = "/students")
    public List<Student> getAllStudent(){
        return this.studentService.findAll();
    }

    @GetMapping(value = "/students/{id}")
    public Student getStudent(@PathVariable Integer id){
        return this.studentService.findById(id);
    }

    @PostMapping(value = "/students")
    public Student saveStudent(Student student){
        return this.studentService.save(student);
    }

    @PutMapping(value = "/students/{id}")
    public Student updateStudent(Student student){
        return this.studentService.save(student);
    }

    @DeleteMapping(value = "/students/{id}")
    public boolean deleteStudent(@PathVariable Integer id){
        return this.studentService.delete(id);
    }
}
