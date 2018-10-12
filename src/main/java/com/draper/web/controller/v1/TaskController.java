package com.draper.web.controller.v1;

import com.draper.service.OneService;
import com.draper.service.TestService;
import com.draper.service.impl.OneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Task")
public class TaskController {

    @Autowired
    private OneService oneService;

    @Autowired
    private TestService testService;

    @RequestMapping("/one")
    public void taskOne(){
        //先插入 1000000 条数据,查询在线 id 为 543210 的学生, 在插入过程中每 100000 条数据输出一下日志
        oneService.task(1000000, 543210, 100000);

        //先插入 30000000 条数据,查询在线 id 为 6543210 的学生, 在插入过程中每 2000000 条数据输出一下日志
        oneService.task(1000000, 6543210, 2000000);

        //先插入 200000000 条数据,查询在线 id 为 198765432 的学生, 在插入过程中每 20000000 条数据输出一下日志
        oneService.task(1000000, 198765432, 20000000);
    }

    @RequestMapping("/test")
    public String taskTest(){
        System.out.println("接收参数");
        testService.taskOne();
        return "fuck";
    }

}
