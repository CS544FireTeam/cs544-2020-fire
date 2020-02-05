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
        Student stud1 = new Student("stud1", "1", "Bob", "M", "100-111-2222", "11223345");
        Faculty facu1 = new Faculty("facu1", "1", "Alice", "N");
        
        userRepository.saveAll(Arrays.asList(admin, sys, stud1, facu1));
        
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
        
        attendanceRepository.saveAll(Arrays.asList(a1));
        
        CourseOffering co1 = new CourseOffering();
        co1.setCourse(c1);
        co1.setFaculty(facu1);
        co1.setLocation(loc1);
        co1.setStartDate(new Date());
        co1.setEndDate(new Date());
        
        courseOfferingRepository.saveAll(Arrays.asList(co1));
        
        Session s1 = new Session(co1, ts1, new Date());
        Session s2 = new Session(co1, ts2, new Date());
        Session s3 = new Session(co1, ts3, new Date());
        
        sessionRepository.saveAll(Arrays.asList(s1, s2, s3));
        
        Registration r1 = new Registration(stud1, co1, new Date());
        
        regisRepository.saveAll(Arrays.asList(r1));
        System.out.println(" -- Database has been initialized");
    }

}
