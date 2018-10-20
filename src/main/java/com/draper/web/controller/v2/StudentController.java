package com.draper.web.controller.v2;

import com.draper.entity.Student;
import com.draper.service.StudentService;
import com.draper.web.to.v2.ResponseTo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.draper.entity.Student.KEY.STUDY_TYPE;
import static com.draper.entity.Student.KEY.DAILY_LINK;
import static com.draper.entity.Student.KEY.COACH_SENIOR;

@Controller
@RequestMapping("/v2")
public class StudentController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ResponseTo responseTo;

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    //获取全部的学生 在界面显示
    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public ModelAndView showStudentList() {

        ModelAndView mav = new ModelAndView("student/studentlist");

        List<Student> students = studentService.selectAllStudent();
        mav.addObject("studentList", students);
        return mav;
    }

    //    获取指定 onlineId 的学生信息
//    ResponseBody 和 RequestBody 都是标记请求参数和返回参数的类型
    @ResponseBody
    @RequestMapping(value = "/student/{onlineId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public Map showStudentInsertPage(@PathVariable int onlineId) {
        Student student = studentService.selectByOnlineId(onlineId);
        return responseTo.msg("success", student);
    }

    //插入一个学生
    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Map insertStudent(@RequestBody @Validated Student student, BindingResult result) {

        if (result.hasErrors()) {
            String errorMessage = result.getFieldError().getDefaultMessage();
            return responseTo.msg("failed");
        } else {
            studentService.insertStudent(student);
            return responseTo.msg("success");
        }

    }

    @ResponseBody
    @RequestMapping(value = "/student/{onlineId}/{key}", method = RequestMethod.PATCH)
    public Map updateStudent(@PathVariable int onlineId, @PathVariable String key, String value) {
        String msg = "success";
        try {
            logger.warn("key = {}, value = {} ", key, value);
            switch (key) {
                case "studyType":
                    studentService.updateStudentByKey(onlineId, STUDY_TYPE, value);
                    break;
                case "dailyLink":
                    studentService.updateStudentByKey(onlineId, DAILY_LINK, value);
                    break;
                case "coachSenior":
                    studentService.updateStudentByKey(onlineId, COACH_SENIOR, value);
                    break;
            }
        } catch (Exception e) {
            msg = "failed";
            e.printStackTrace();
        } finally {
            return responseTo.msg(msg);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/student/{onlineId}", method = RequestMethod.DELETE)
    public Map deleteStudent(@PathVariable int onlineId) {
        Student student = new Student();
        student.setOnlineId(onlineId);
        studentService.deleteStudent(student);
        return responseTo.msg("success");
    }

    //required = false 可以不传参数， required = true 必须传参数
    @ResponseBody
    @RequestMapping(value = "/student/page/{page}", method = RequestMethod.GET)
    public Map getList(
            @PathVariable int page,
            @RequestParam(required = false, defaultValue = "10") int rows) {

        //只对该语句以后的第一个查询语句得到的数据进行分页
        //所以避免分页有时候有效果有时候没效果要立即调用 Mybatis 进行查询较好
        PageHelper.startPage(page, rows);
        List<Student> students = studentService.selectAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        return responseTo.msg("success", pageInfo);

    }

}
