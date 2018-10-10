package com.draper.service.impl;

import com.draper.entity.Student;
import com.draper.mapper.StudentMapper;
import com.draper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void insertStudent(Student student) throws DuplicateKeyException {
        studentMapper.insertItStudent(student);
        studentMapper.insertSimpleStudent(student);
    }

    @Override
    public Student selectByOnlineId(int onlineId) throws NullPointerException {
        Student student = studentMapper.selectByOnlineId(onlineId);
        if (student == null) {
            throw new NullPointerException("Can't select student by online id");
        }
        return student;
    }

    @Override
    public void updateByOnlineId(Student student) throws NullPointerException {
        Student queryStudent = studentMapper.selectByOnlineId(student.getOnlineId());
        if (queryStudent == null) {
            throw new NullPointerException("Can't update student by online id");
        }
        studentMapper.deleteItStudentByOnlineId(student.getOnlineId());
        studentMapper.deleteSimpleStudent(student.getOnlineId());
        studentMapper.insertItStudent(student);
        studentMapper.insertSimpleStudent(student);
    }


    @Override
    public void deleteStudent(Student student) {
        student = studentMapper.selectByOnlineId(student.getOnlineId());
        if (student == null) {
            throw new NullPointerException("Can't delete student by online id");
        }
        studentMapper.deleteSimpleStudent(student.getOnlineId());
        studentMapper.deleteItStudentByOnlineId(student.getOnlineId());
    }
}
