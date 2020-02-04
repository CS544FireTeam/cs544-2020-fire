package edu.mum.cs.cs544.config;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import edu.mum.cs.cs544.dao.*;
import edu.mum.cs.cs544.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitializer implements CommandLineRunner {

	@Autowired
    private UserRepository userRepository;

	@Autowired
    private AdminRepository adminRepository;

	@Autowired
    private StudentRepository studentRepository;

	@Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private CourseOfferingRepository courseOfferingRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public void run(String... strings) throws Exception {
        userRepository.deleteAll();

        Admin admin = new Admin("admin", "admin", "Peter", "Yellow");
        Admin sys = new Admin("sys", "sys", "Mike", "Rooler");
        adminRepository.saveAll(Arrays.asList(admin, sys));

        /*
         * Course
         * */
        Course course = new Course("CS544", "Enterprise Architecture","Abbr" ,"Enterprise Architecture");
        courseRepository.save(course);

        /*
        * Session and Course offering
        * */

//        Calendar calendar = Calendar.getInstance();
//
//        CourseOffering courseOffering = new CourseOffering();
//        courseOffering.setStartDate(calendar.getTime());
//        calendar.add(Calendar.MONTH , 1);
//        courseOffering.setEndDate(calendar.getTime());
//        courseOffering.setCourse(course);
//        this.courseOfferingRepository.save(courseOffering);
//
//        Session session = new Session();
//        session.setDate(Calendar.getInstance().getTime());
//        session.setCourseOffering(courseOffering);
//        this.sessionRepository.save(session);


        /*
        * Faculty
        * */
        Faculty faculty = new Faculty("faculty1", "faculty1", "Peter", "Yellow");
        this.facultyRepository.save(faculty);


        /*
         * Student
         * */
        Student student = new Student("student1", "faculty1", "Peter", "Yellow","1","1");
        this.studentRepository.save(student);
        System.out.println(" -- Database has been initialized");
    }

}
