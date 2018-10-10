package com.draper.dao;

import com.draper.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public interface StudentDao {

    void insertItStudent(Student student);

    void insertSimpleStudent(Student student);

    void updateWishByName(String name,  String wish);

    //    Map selectByName(@Param("name") String name);
    Student selectByName(String name);

    void deleteItStudentByOnlineId(int onlineId);

    void deleteSimpleStudent(int onlineId);

    JdbcTemplate getJdbcTemplate();


}
