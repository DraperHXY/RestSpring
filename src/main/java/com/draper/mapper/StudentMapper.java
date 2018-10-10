package com.draper.mapper;

import com.draper.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface StudentMapper {

    void insertItStudent(Student student);

    void insertSimpleStudent(Student student);

    void updateWishByName(@Param("name") String name, @Param("wish") String wish);

    //    Map selectByName(@Param("name") String name);
    Student selectByName(String name);

    Student selectByOnlineId(int onlineId);

    void deleteItStudentByOnlineId(int onlineId);

    void deleteSimpleStudent(int onlineId);

    void insertItByBatch(List<Student> students);

}
