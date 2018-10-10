package com.draper.dao;

import com.draper.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void insertItStudent(Student student) {
        jdbcTemplate.execute(
                "INSERT INTO it_mates_table(create_at, online_id, study_type, start_study_time, daily_link, wish, coach_senior, know_from)" +
                        "VALUES ('"
                        + student.getCreateAt()
                        + "','" + student.getOnlineId()
                        + "','" + student.getStudyType()
                        + "','" + student.getStartStudyTime()
                        + "','" + student.getDailyLink()
                        + "','" + student.getWish()
                        + "','" + student.getCoachSenior()
                        + "','" + student.getKnowFrom()
                        + "');"
        );
    }

    @Override
    public void insertSimpleStudent(Student student) {
        jdbcTemplate.execute(
                "INSERT INTO simple_mates_table (create_at, online_id, name, qq, graduate_school)" +
                        "VALUES ('" +
                        +student.getCreateAt()
                        + "','" + student.getOnlineId()
                        + "','" + student.getName()
                        + "','" + student.getQq()
                        + "','" + student.getGraduateSchool()
                        + "');"
        );
    }

    @Override
    public void updateWishByName(String name, String wish) {

    }

    @Override
    public Student selectByName(String name) {
        return null;
    }

    @Override
    public void deleteItStudentByOnlineId(int onlineId) {
        jdbcTemplate.execute(
                "DELETE FROM it_mates_table " +
                        "WHERE online_id = '" + onlineId + "';"
        );
    }

    @Override
    public void deleteSimpleStudent(int onlineId) {
        jdbcTemplate.execute("DELETE FROM simple_mates_table " +
                "WHERE online_id = '" + onlineId + "';");
    }

    @Override
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
