package com.draper.web.controller.v1;

import com.draper.service.StudentService;
import com.draper.web.to.v1.StudentGet;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/v1")
public class RestController {

    @Autowired
    private StudentService studentService;

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String insertStudent() {

        return "student/insert";
    }

    @ResponseBody
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public Object selectStudent(@PathVariable("id") int id) throws UnsupportedEncodingException, JsonProcessingException {
        StudentGet student = new StudentGet(1, "ok", studentService.selectByOnlineId(id));

//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writerWithDefaultPrettyPrinter()
//                .writeValueAsString(student);
        return student;
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.PATCH)
    public String updateStudent() {
//        studentService.updateStudentByKey();
        return "student/update";
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.DELETE)
    public String deleteStudent() {
        return "student/delete";
    }

}
