package com.draper.mapper;

import com.draper.BaseTest;
import com.draper.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentMapperTest extends BaseTest {

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Autowired
    private StudentMapper studentMapper;

    @Before
    public void testInsertStudent() throws ParseException {
        logger.warn("采用 MyBatis 插入");
        logger.info("current time {}", new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long time_long = sdf.parse("2018-10-2").getTime();
        Student student = new Student();
        student.setCreateAt(System.currentTimeMillis());
        student.setOnlineId(4975);
        student.setStudyType("JAVA工程师");
        student.setStartStudyTime(time_long);
        student.setDailyLink("http://www.jnshu.com/school/86/daily");
        student.setWish("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2k斤！");
        student.setCoachSenior("桂伟腾");
        student.setKnowFrom("知乎");
        student.setName("贾伟奇");
        student.setQq("860733414");
        student.setGraduateSchool("北京YD大学");
        studentMapper.insertItStudent(student);
        studentMapper.insertSimpleStudent(student);
    }

//    @Test
//    public void testSelectByName() {
////        String coachSenior = (String) studentMapper.selectByName("贾伟奇").get("coachSenior");
////        System.out.println(coachSenior);
//        Map map = studentMapper.selectByName("贾伟奇");
//        Set set  = map.keySet();
//        for (Object o : set) {
//            System.out.println(o + "：" + map.get(o));
//        }
//    }

    @Test
    public void testSelectByName() {
        logger.warn("采用 MyBatis 查找");
        Student student = studentMapper.selectByName("贾伟奇");
    }

    @Test
    public void testSelectById() {
        logger.warn("采用 MyBatis 查找");
        Student student = studentMapper.selectByOnlineId(4975);
        logger.debug(student.getCoachSenior());
    }



    @Test
    public void testUpdateWishByName() {
        logger.warn("采用 MyBatis 修改");
        studentMapper.updateWishByName("贾伟奇", "老大最帅！");
    }

//    @Test
//    public void testInsertTenStudent() throws ParseException {
//        int id = 10000;
//        for (int i = 0; i < 10; i++) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            long time_long = sdf.parse("2018-10-2").getTime();
//            Student student = new Student();
//            student.setCreateAt(System.currentTimeMillis());
//            student.setOnlineId(id+i);
//            student.setStudyType("JAVA工程师");
//            student.setStartStudyTime(time_long);
//            student.setDailyLink("http://www.jnshu.com/school/86/daily");
//            student.setWish("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2k斤！");
//            student.setCoachSenior("桂伟腾");
//            student.setKnowFrom("知乎");
//            student.setName("贾伟奇");
//            student.setQq("860733414");
//            student.setGraduateSchool("北京YD大学");
//            studentMapper.insertItStudent(student);
//            studentMapper.insertSimpleStudent(student);
//        }
//    }

    @After
    public void testDeleteStudentByOnlineId() {
        logger.warn("采用 MyBatis 删除");
        logger.info("current time {}", new Date());
        studentMapper.deleteItStudentByOnlineId(4975);
        studentMapper.deleteSimpleStudent(4975);
    }

//    @Test
//    public void testInsert1000Student() throws ParseException {
//        int id = 10000;
//        for (int i = 0; i < 1000; i++) {
//            logger.debug("插入第 {} 条数据", i);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            long time_long = sdf.parse("2018-10-2").getTime();
//            Student student = new Student();
//            student.setCreateAt(System.currentTimeMillis());
//            student.setOnlineId(id + i);
//            student.setStudyType("JAVA工程师");
//            student.setStartStudyTime(time_long);
//            student.setDailyLink("http://www.jnshu.com/school/86/daily");
//            student.setWish("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2k斤！");
//            student.setCoachSenior("桂伟腾");
//            student.setKnowFrom("知乎");
//            student.setName("贾伟奇");
//            student.setQq("860733414");
//            student.setGraduateSchool("北京YD大学");
//            studentMapper.insertItStudent(student);
//            studentMapper.insertSimpleStudent(student);
//        }
//    }

//    @Test
//    public void testInsertItByBatch(){
//        List<Student> students = new ArrayList<>();
//        int id = 10000;
//        for (int i = 0; i < 100000; i++) {
////            logger.debug("插入第 {} 条数据", i);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            long time_long = 0;
//            try {
//                time_long = sdf.parse("2018-10-2").getTime();
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            Student student = new Student();
//            student.setCreateAt(System.currentTimeMillis());
//            student.setOnlineId(id + i);
//            student.setStudyType("JAVA工程师");
//            student.setStartStudyTime(time_long);
//            student.setDailyLink("http://www.jnshu.com/school/86/daily");
//            student.setWish("如果我不能在IT特训营拼尽全力，为自己以后的修行路上打好基础，就让我变胖2k斤！");
//            student.setCoachSenior("桂伟腾");
//            student.setKnowFrom("知乎");
//            student.setName("贾伟奇");
//            student.setQq("860733414");
//            student.setGraduateSchool("北京YD大学");
//            students.add(student);
//        }
//
//        studentMapper.insertItByBatch(students);
//    }
}
