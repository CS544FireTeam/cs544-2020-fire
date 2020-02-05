package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Admin;
import edu.mum.cs.cs544.model.Faculty;
import edu.mum.cs.cs544.model.Student;
import edu.mum.cs.cs544.model.User;
import edu.mum.cs.cs544.service.AdminService;
import edu.mum.cs.cs544.service.FacultyService;
import edu.mum.cs.cs544.service.StudentService;
import edu.mum.cs.cs544.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    public UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(userService.getAll(null));
    }

    @PostMapping(value = "/admin")
    public Admin addAdmin(@Valid @RequestBody Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return this.adminService.create(admin);
    }

    @PostMapping(value = "/student")
    public Student addStudent(@Valid @RequestBody Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return this.studentService.create(student);
    }

    @PostMapping(value = "/faculty")
    public Faculty addFaculty(@Valid @RequestBody Faculty faculty) {
        faculty.setPassword(passwordEncoder.encode(faculty.getPassword()));
        return this.facultyService.create(faculty);
    }
}
