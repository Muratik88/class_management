package com.company.model;

import java.util.Date;

public class Group {
    private int id;
    private int courseId;
    private int teacherId;
    private Date startDate;

    public Group(int id, int courseId, int teacherId, Date startDate) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.startDate = startDate;
    }

    public Group(int courseId, int teacherId, Date startDate) {
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
