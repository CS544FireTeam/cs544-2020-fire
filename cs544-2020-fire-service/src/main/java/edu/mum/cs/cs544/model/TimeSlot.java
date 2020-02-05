package edu.mum.cs.cs544.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.util.Date;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue
    private Integer id;
    
    @NotNull @Column(length = 255)
    private String description;
    
    @DateTimeFormat(pattern="mm:ss")
    @JsonFormat(pattern="mm:ss")
    @NotNull
    private LocalTime beginTime;
    
    @DateTimeFormat(pattern="mm:ss")
    @JsonFormat(pattern="mm:ss")
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
