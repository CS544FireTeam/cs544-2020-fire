package edu.mum.cs.cs544.dto;


import edu.mum.cs.cs544.model.Attendance;

public class AttendanceSearchRequestDTO {
    Integer studentId;
    Integer courseId;
    Integer courseOfferingId;

    public AttendanceSearchRequestDTO() {
    }

    public AttendanceSearchRequestDTO(Integer studentId, Integer courseId, Integer courseOfferingId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseOfferingId = courseOfferingId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(Integer courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

//    public static AttendanceSearchRequestDTO build(Attendance ob) {
//        //TODO
//        return null;
//    }
}
