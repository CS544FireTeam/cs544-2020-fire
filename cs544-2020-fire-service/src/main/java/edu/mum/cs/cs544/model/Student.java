package edu.mum.cs.cs544.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Student extends User {

	@NotBlank //TODO update by format requiment
	@Column(length = 255, unique = true)
    private String studentCode;
	
	@NotBlank
	@Column(length = 20)
    private String barcode;


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<Registration> registrations = new ArrayList<>();

    public Student() {
		super();
    }

    public Student(String username, String password, String firstName, String lastName, String studentCode, String barcode) {
        super(username, password, firstName, lastName, UserRole.STUDENT);
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
