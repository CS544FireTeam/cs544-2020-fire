package edu.mum.cs.cs544.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import edu.mum.cs.cs544.dao.AdminRepository;
import edu.mum.cs.cs544.dao.FacultyRepository;
import edu.mum.cs.cs544.dao.StudentRepository;
import edu.mum.cs.cs544.dao.UserRepository;
import edu.mum.cs.cs544.model.Admin;

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
    
    @Override
    public void run(String... strings) throws Exception {
        userRepository.deleteAll();
        
        Admin admin = new Admin("admin", "admin", "Peter", "Yellow");
        Admin sys = new Admin("sys", "sys", "Mike", "Rooler");
        adminRepository.saveAll(Arrays.asList(admin, sys));
        
        System.out.println(" -- Database has been initialized");
    }
    
}
