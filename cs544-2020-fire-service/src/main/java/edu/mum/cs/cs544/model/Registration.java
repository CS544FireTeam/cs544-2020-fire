package edu.mum.cs.cs544.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Registration {

	@Id @GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY) @NotNull
	@JoinColumn(name="student_id")
	private Student student;
	
	@Temporal(TemporalType.DATE) @NotNull
	private Date registerDate; 
	
	@ManyToOne(fetch = FetchType.LAZY) @NotNull
	private CourseOffering courseOffering;
	
	public Registration() {
		
	}

	public Registration(Student s, CourseOffering c, Date d) {
		this.student = s;
		this.courseOffering = c;
		this.registerDate = d;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public CourseOffering getCourseOffering() {
		return courseOffering;
	}
	
	public void setCourseOffering(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}
	
	
}
