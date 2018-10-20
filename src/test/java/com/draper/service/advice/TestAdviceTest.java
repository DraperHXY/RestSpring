package com.draper.service.advice;

import com.draper.service.StudentService;
import com.draper.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class TestAdviceTest {

    @Test
    public void before() {

        StudentService target = new StudentServiceImpl();
        BeforeAdvice beforeAdvice  = new TestAdvice();

        ProxyFactory pf = new ProxyFactory();

        pf.setTarget(target);
        pf.addAdvice(beforeAdvice);

        StudentService proxy = (StudentService) pf.getProxy();
        proxy.selectAllStudent();
    }

}
