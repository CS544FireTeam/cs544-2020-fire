package edu.mum.cs.cs544.web;

import edu.mum.cs.cs544.model.CourseOffering;
import edu.mum.cs.cs544.service.courseOffering.ICourseOfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CourseOfferingController {

    @Autowired
    private ICourseOfferingService courseOfferingService;

    @GetMapping(value = "/course-offering")
    public List<CourseOffering> getAllCourseOffering(){
        return this.courseOfferingService.findAll();
    }

    @GetMapping(value = "/course-offering/{id}")
    public CourseOffering getCourseOfferingById(@PathVariable Integer id){
        return this.courseOfferingService.findById(id);
    }

    @PostMapping(value = "/course-offering")
    public CourseOffering saveCourseOffering(@RequestBody @Valid CourseOffering courseOffering){
        return this.courseOfferingService.save(courseOffering);
    }

    @PutMapping(value = "/course-offering/{id}")
    public CourseOffering updateCourseOffering(@RequestBody @Valid CourseOffering courseOffering){
        return this.courseOfferingService.save(courseOffering);
    }

    @DeleteMapping(value = "/course-offering/{id}")
    public boolean deleteCourseOffering(@PathVariable Integer id){
        return this.courseOfferingService.delete(id);
    }
}
