package edu.mum.cs.cs544.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.mum.cs.cs544.validation.ValidTime;

import java.time.LocalTime;

@Entity @ValidTime
public class TimeSlot {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotNull @Column(length = 255)
    private String description;
    
    @DateTimeFormat(pattern="hh:mm")
    @JsonFormat(pattern="hh:mm")
    @NotNull
    private LocalTime beginTime;
    
    @DateTimeFormat(pattern="hh:mm")
    @JsonFormat(pattern="hh:mm")
    @NotNull
    private LocalTime endTime;

    public TimeSlot() {
    }

    public TimeSlot(String d, LocalTime b, LocalTime e) {
		this.description = d;
		this.beginTime = b;
		this.endTime = e;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public LocalTime getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(LocalTime beginTime) {
		this.beginTime = beginTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	

}
