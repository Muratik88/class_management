package com.company.services;

import com.company.model.Group;
import com.company.model.Student;

public interface AdministratorService {
    void registerStudent(Student student, Group group);
    void unRegisterStudent(Student student, Group group);
}