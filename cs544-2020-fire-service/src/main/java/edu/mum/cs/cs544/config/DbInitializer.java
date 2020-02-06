package edu.mum.cs.cs544.config;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;
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
    
    @Autowired
    private LocationRepository locationRepository;
    
    @Autowired
    private TimeSlotRepository tsRepository;
    
    @Autowired
    private AttendanceRepository attendanceRepository;
    
    @Autowired
    private RegistrationRepository regisRepository;


    @Override
    public void run(String... strings) throws Exception {
    	User admin = new Admin("admin", "admin", "Peter", "Yellow");
        User sys = new Admin("sys", "sys", "Jame", "Bond");
        Student stud1 = new Student("stud1", "1", "Bob", "M", "100-111-2222", "12223345");
        Student stud2 = new Student("stud2", "2", "Bob2", "M2", "200-111-2222", "21223345");
        Faculty facu1 = new Faculty("facu1", "1", "Alice", "N");
        
        userRepository.saveAll(Arrays.asList(admin, sys, stud1, stud2, facu1));
        
        Location loc1 = new Location("M001");
        Location loc2 = new Location("V001");
        
        locationRepository.saveAll(Arrays.asList(loc1, loc2));
        
        Course c1 = new Course("cs544", "Enterprise Architecture", "AM", "blah");
        Course c2 = new Course("cs545", "Web application architecture", "AM", "blah");
        
        courseRepository.saveAll(Arrays.asList(c1, c2));
        
        SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm");
        
        
        TimeSlot ts1 = new TimeSlot("Morning Meditation", LocalTime.of(7, 0), LocalTime.of(11, 0));
        TimeSlot ts2 = new TimeSlot("Regular Morning", LocalTime.of(10, 0), LocalTime.of(12, 30));
        TimeSlot ts3 = new TimeSlot("Regular Afternoon", LocalTime.of(13, 30), LocalTime.of(16, 0));
        
        tsRepository.saveAll(Arrays.asList(ts1, ts2, ts3));
        
        Attendance a1 = new Attendance();
        a1.setAttendedDate(new Date());
        a1.setLocation(loc1);
        a1.setTimeSlot(ts1);
        a1.setStudent(stud1);

        Attendance a2 = new Attendance();
        a2.setAttendedDate(new Date());
        a2.setLocation(loc2);
        a2.setTimeSlot(ts2);
        a2.setStudent(stud2);

        Attendance a3 = new Attendance();
        a3.setAttendedDate(new Date());
        a3.setLocation(loc2);
        a3.setTimeSlot(ts3);
        a3.setStudent(stud2);
        
        attendanceRepository.saveAll(Arrays.asList(a1, a2, a3));
        
        CourseOffering co1 = new CourseOffering();
        co1.setCourse(c1);
        co1.setFaculty(facu1);
        co1.setLocation(loc1);
        co1.setStartDate(new Date());
        co1.setEndDate(new Date());

        CourseOffering co2 = new CourseOffering();
        co2.setCourse(c2);
        co2.setFaculty(facu1);
        co2.setLocation(loc2);
        co2.setStartDate(new Date());
        co2.setEndDate(new Date());

        CourseOffering co3 = new CourseOffering();
        co3.setCourse(c2);
        co3.setFaculty(facu1);
        co3.setLocation(loc2);
        co3.setStartDate(new Date());
        co3.setEndDate(new Date());
        
        courseOfferingRepository.saveAll(Arrays.asList(co1, co2, co3));
        
        Session s1 = new Session(co1, ts1, new Date());
        Session s2 = new Session(co2, ts2, new Date());
        Session s3 = new Session(co3, ts3, new Date());
        
        sessionRepository.saveAll(Arrays.asList(s1, s2, s3));
        
        Registration r1 = new Registration(stud1, co1, new Date());
        
        regisRepository.saveAll(Arrays.asList(r1));
        System.out.println(" -- Database has been initialized");
    }

}
