package edu.mum.cs.cs544.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TimeSlot {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @Temporal(TemporalType.TIME)
    private Date beginTime;
    @Temporal(TemporalType.TIME)
    private Date endTime;

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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
