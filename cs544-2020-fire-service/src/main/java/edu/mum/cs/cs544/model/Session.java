package edu.mum.cs.cs544.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Session {
    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)  @NotNull
    private CourseOffering courseOffering;
    
    @ManyToOne(fetch = FetchType.LAZY) @NotNull
    private TimeSlot timeSlot;
    
    @Temporal(TemporalType.DATE) @NotNull
    private Date date;

    public Session() {
    }

    public Session(CourseOffering c, TimeSlot t, Date d) {
		this.courseOffering = c;
		this.timeSlot = t;
		this.date = d;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
