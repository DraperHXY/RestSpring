package com.draper.service.impl;

import com.draper.entity.Student;
import com.draper.mapper.StudentMapper;
import com.draper.service.OneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class OneServiceImpl implements OneService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    public void task(int insertNum, int selectNum, int checkStep) {
        //先插入 1000000 条数据
        for (int i = 0; i < insertNum; i++) {
            logger.info("正在插入第{}条数据", i);
            checkInsertNum(i, checkStep);//输出插入到第几条数据
            insertStudent(i);
        }

        selectStudent(selectNum);//无索引查询

        addDbIndex();//添加索引
        selectStudent(selectNum);//有索引查询

        removeIndex();//移除索引
    }

    private void insertStudent(int id) {
        logger.info("采用 MyBatis 插入");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long time_long = 0;
        try {
            time_long = sdf.parse("2018-10-2").getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student();
        student.setCreateAt(System.currentTimeMillis());
        student.setOnlineId(id);
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

    private void selectStudent(int id) {
        logger.info("采用 MyBatis 查找");
        logger.warn("查找开始");
        Student student = studentMapper.selectByOnlineId(id);
        logger.warn("查找结束，id{}的学员的辅导师兄是{}", id, student.getCoachSenior());
    }

    private void updateStudent() {
        logger.info("采用 MyBatis 修改");
        studentMapper.updateWishByName("贾伟奇", "老大最帅！");
    }

    private void deleteStudent() {
        logger.info("采用 MyBatis 删除");
        studentMapper.deleteItStudentByOnlineId(4975);
        studentMapper.deleteSimpleStudent(4975);
    }

    private void addDbIndex() {
        logger.warn("添加 INDEX");
        jdbcTemplate.execute("ALTER TABLE it_mates_table ADD INDEX idx_it_online_id (online_id);");
        jdbcTemplate.execute("ALTER TABLE simple_mates_table ADD INDEX idx_simple_online_id (online_id);");
    }


    private void removeIndex() {
        logger.warn("移除 INDEX");
        jdbcTemplate.execute("ALTER TABLE it_mates_table DROP INDEX idx_it_online_id (online_id);");
        jdbcTemplate.execute("ALTER TABLE simple_mates_table DROP INDEX idx_simple_online_id (online_id);");
    }

    private void checkInsertNum(int id,int step) {
        if (id % step == 0) {
            logger.warn("插入到第{}条数据", id);
        }
    }



}
