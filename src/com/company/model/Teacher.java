package com.company.model;

import java.util.List;

public class Teacher extends Person{
    private List<Integer> courser_list ;


    public Teacher(int id, String name, String phone, String address,List<Integer> courser_list) {
        super(id, name, phone, address);
        this.courser_list = courser_list;
    }

    public Teacher(String name, String phone, String address, List<Integer> courser_list) {
        super(name, phone, address);
        this.courser_list = courser_list;
    }

    public List<Integer> getCourser_list() {
        return courser_list;
    }

    public void setCourser_list(List<Integer> courser_list) {
        this.courser_list = courser_list;
    }
}
