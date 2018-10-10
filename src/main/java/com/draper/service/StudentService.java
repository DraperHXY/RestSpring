package com.draper.service;

import com.draper.entity.Student;
import org.springframework.dao.DuplicateKeyException;


public interface StudentService {

    void insertStudent(Student student) throws DuplicateKeyException;

    Student selectByOnlineId(int onlineId) throws NullPointerException;

    void updateByOnlineId(Student student) throws NullPointerException;

    void deleteStudent(Student student) throws NullPointerException;


}
