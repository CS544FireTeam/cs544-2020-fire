package edu.mum.cs.cs544.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Student extends User {

    private String studentCode;
    private String barcode;


    @OneToMany(mappedBy = "student")
    private List<Registration> registrations = new ArrayList<>();

    public Student() {
		super();
    }

    public Student(String username, String password, String firstName, String lastname, String studentCode, String barcode) {
        super(username, password, firstName, lastname, UserRole.STUDENT);
        this.studentCode = studentCode;
        this.barcode = barcode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
