package com.company.model;

public class Course {
    private int id_course;
    private String name;
    private int duration;
    private double price;


    public Course(int id_course, String name, double price, int duration) {
        this.id_course = id_course;
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public Course(String name, double price, int duration) {
        this.name = name;
        this.price = price;
        this.duration = duration;
    }

    public Course(int id_course, String name) {
        this.id_course = id_course;
        this.name = name;
    }

    public int getId_course() {
        return id_course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return getName();
    }
}
