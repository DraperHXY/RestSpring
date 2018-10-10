package com.draper.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class RestController {

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String insertStudent(){
        logger.warn("post student");
        return "student/insert";
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String selectStudent(){
        logger.warn("get student");
        return "student/select";
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.PUT)
    public String updateStudent(){
        logger.warn("put student");
        return "student/update";
    }

    @ResponseBody
    @RequestMapping(value = "/student", method = RequestMethod.DELETE)
    public String deleteStudent(){
        logger.warn("delete student");
        return "student/delete";
    }

}
