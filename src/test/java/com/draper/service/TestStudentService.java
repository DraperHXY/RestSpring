package com.draper.service;

import com.draper.BaseTest;
import com.draper.entity.Student;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

public class TestStudentService extends BaseTest {

    Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Autowired
    private StudentService studentService;

    @Test
    public void testInsertStudent() {
        int j = 1;
        Student student = new Student();
        student.setOnlineId(10001);
        try {
            studentService.insertStudent(student);
        } catch (DuplicateKeyException e) {
            j = 99;
            e.printStackTrace();
        } finally {
            logger.warn(j + "抛出异常");

        }
    }

    @Test
    public void testSelectStudent() {
        Student student;

        try {
            student = studentService.selectByOnlineId(5);
        } catch (NullPointerException e){
            logger.warn("数据库中没找到该数据");
        } finally {
            logger.warn("成功返回");
        }
    }

    @Test
    public void testUpdateStudent(){
        Student student = new Student();
        student.setName("小明");
        try {
            studentService.updateByOnlineId(student);
        } catch (Exception e) {
            logger.warn("数据库中没找到该数据");
        }finally {
            logger.warn("成功返回");
        }
    }

    @Test
    public void testDeleteStudent(){
        Student student = new Student();
        student.setOnlineId(5);
        try {
            studentService.deleteStudent(student);
        } catch (NullPointerException e){
            logger.warn("数据库中没找到该数据");
        }finally {
            logger.warn("成功返回");
        }
    }



}
