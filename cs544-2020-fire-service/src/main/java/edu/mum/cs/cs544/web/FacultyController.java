package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Faculty;
import edu.mum.cs.cs544.service.faculty.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyController {

    @Autowired
    private IFacultyService facultyService;

    @GetMapping(value = "/faculties")
    public List<Faculty> getAllFaculty(){
        return this.facultyService.findAll();
    }

    @GetMapping(value = "/faculties/{id}")
    public Faculty getFaculty(@PathVariable Integer id){
        return this.facultyService.findById(id);
    }

    @PostMapping(value = "/faculties")
    public Faculty saveFaculty(Faculty faculty){
        return this.facultyService.save(faculty);
    }

    @PutMapping(value = "/faculties/{id}")
    public Faculty updateFaculty(Faculty faculty){
        return this.facultyService.save(faculty);
    }

    @DeleteMapping(value = "/faculties/{id}")
    public boolean deleteFaculty(@PathVariable Integer id){
        return this.facultyService.delete(id);
    }
}
