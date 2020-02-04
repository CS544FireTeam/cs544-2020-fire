package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.Course;
import edu.mum.cs.cs544.service.course.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping(value = "/courses")
    public List<Course> getAllCourse(){
        return this.courseService.findAll();
    }

    @GetMapping(value = "/courses/{id}")
    public Course getCourse(@PathVariable Integer id){
        return this.courseService.findById(id);
    }

    @PostMapping(value = "/courses")
    public Course saveCourse(Course course){
        return this.courseService.save(course);
    }

    @PutMapping(value = "/courses/{id}")
    public Course updateCourse(Course course){
        return this.courseService.save(course);
    }

    @DeleteMapping(value = "/courses/{id}")
    public boolean deleteCourse(@PathVariable Integer id){
        return this.courseService.delete(id);
    }
}
