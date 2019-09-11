package com.company.model;

import java.time.LocalDate;
import java.util.Date;

public class Group {
    private int id;
    private int courseId;
    private int teacherId;
    private LocalDate startDate;

    public Group(int id, int courseId, int teacherId, LocalDate startDate) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.startDate = startDate;
    }

    public Group(int courseId, int teacherId, LocalDate startDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
