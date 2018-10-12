package com.draper.dao;

import com.draper.BaseTest;
import com.draper.entity.Student;
import org.junit.After;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StudentDaoTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Autowired
    private StudentDao studentDao;

//    @Test
    public void testInsertItStudent(int i) throws ParseException {
        logger.warn("采用 JdbcTemplate 插入");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long time_long = sdf.parse("2018-10-2").getTime();
        Student student = new Student();
        student.setCreateAt(System.currentTimeMillis());
        student.setOnlineId(i);
        student.setStudyType("JAVA工程师");
        student.setStartStudyTime(time_long);
        student.setDailyLink("http://www.jnshu.com/school/86/daily");
        student.setWish("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2k斤！");
        student.setCoachSenior("桂伟腾");
        student.setKnowFrom("知乎");
        student.setName("贾伟奇");
        student.setQq("860733414");
        student.setGraduateSchool("北京YD大学");

        studentDao.insertItStudent(student);
        studentDao.insertSimpleStudent(student);

    }

    @Test
    public void testTryCatch() throws ParseException {

        for (int i = 10; i < 50; i++) {
            testInsertItStudent(i);
        }
    }


    @Test
    public void testDeleteStudent() {
        logger.warn("采用 JdbcTemplate 删除");
        studentDao.deleteItStudentByOnlineId(4975);
        studentDao.deleteSimpleStudent(4975);
    }

}
