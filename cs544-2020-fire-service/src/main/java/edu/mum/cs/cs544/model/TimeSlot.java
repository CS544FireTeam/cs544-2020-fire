package edu.mum.cs.cs544.model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    
    @DateTimeFormat(pattern="mm:ss")
    @JsonFormat(pattern="mm:ss")
    private LocalTime beginTime;
    
    @DateTimeFormat(pattern="mm:ss")
    @JsonFormat(pattern="mm:ss")
    private LocalTime endTime;

    public TimeSlot() {
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
