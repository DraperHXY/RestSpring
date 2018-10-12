package com.draper.web.controller.v2;

import com.draper.entity.Student;
import com.draper.service.StudentService;
import com.draper.web.to.v1.StudentGet;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.draper.entity.Student.KEY.STUDY_TYPE;
import static com.draper.entity.Student.KEY.DAILY_LINK;
import static com.draper.entity.Student.KEY.COACH_SENIOR;

@Controller
@RequestMapping("/v2")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @RequestMapping(value = "/student/list", method = RequestMethod.GET)
    public ModelAndView showStudentList() {

        ModelAndView mav = new ModelAndView("student/studentlist");

        List<Student> students = studentService.selectAllStudent();
        mav.addObject("studentList", students);
        return mav;
    }

    @RequestMapping(value = "/student/page/insert", method = RequestMethod.GET)
    public String showStudentInsertPage() {
        return "page/insert";
    }


    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView insertStudent(@RequestBody Student student) {
        ModelAndView mav = new ModelAndView("page/success");
        logger.warn(String.valueOf(student.getName()));
        studentService.insertStudent(student);
        return mav;

    }

    //    ResponseBody 和 RequestBody 都是标记请求参数和返回参数的类型
    @ResponseBody
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public Object selectStudent(@RequestBody int onlineId) {
        StudentGet student = new StudentGet(1, "ok", studentService.selectByOnlineId(onlineId));


        return student;
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.PATCH)
    public String updateStudent(@RequestBody String key, @RequestBody int onlineId, Object value) {
        try {
            switch (key) {
                case "studyType":
//                    studentService.updateStudentByKey(onlineId, STUDY_TYPE, value);
                    break;
                case "dailyLink":
//                    studentService.updateStudentByKey(onlineId, DAILY_LINK, value);
                    break;
                case "coachSenior":
//                    studentService.updateStudentByKey(onlineId, COACH_SENIOR, value);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "student/update";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.DELETE)
    public String deleteStudent() {
        return "student/delete";
    }

    //required = false 可以不传参数， required = true 必须传参数
    @ResponseBody
    @RequestMapping(value = "/student/page/{page}" ,method = RequestMethod.GET)
    public PageInfo<Student> getList(
            @PathVariable int page,
            @RequestParam(required = false, defaultValue = "10") int rows) {

        //只对该语句以后的第一个查询语句得到的数据进行分页
        //所以避免分页有时候有效果有时候没效果要立即调用 Mybatis 进行查询较好
        PageHelper.startPage(page, rows);
        List<Student> students = studentService.selectAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(students);

        return pageInfo;
    }

}
