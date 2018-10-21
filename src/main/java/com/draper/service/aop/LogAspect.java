package com.draper.service.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Pointcut("execution(* com.draper.service*.*.*(int))")
    public void aspectInt() {
        logger.warn("I'm in int pointcut now, emmmm, but't I don't know When there be execute");
    }


    @Before("aspectInt()")
    public void beforeLog(JoinPoint jp) {
    }

    @Around("aspectInt()")
    public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
        logger.warn("@aspectInt Around before pjp.proceed: class = {}", pjp.getSignature().getDeclaringTypeName());
        logger.warn("@aspectInt Around before pjp.proceed: method = {}", pjp.getSignature().getName());
        logger.warn("@aspectInt Around before pjp.proceed: args = {}", pjp.getArgs());
        Object obj = pjp.proceed();
        logger.warn("@aspectInt Around after pjp.proceed: class = {}", pjp.getSignature().getDeclaringTypeName());
        logger.warn("@aspectInt Around after pjp.proceed: method = {}", pjp.getSignature().getName());
        logger.warn("@aspectInt Around after pjp.proceed: args = {}", pjp.getArgs());
        return obj;
    }

    @After("aspectInt()")
    public void afterLog(JoinPoint jp) {
        logger.info("@LogAspect after :class = {}", jp.getClass().getName());
    }


    @Pointcut("execution(* com.draper.service*.*.*(com.draper.entity.Student))")
    public void aspectStudent() {
    }

    @Around("aspectStudent()")
    public Object aroundStudentLog(ProceedingJoinPoint pjp) throws Throwable {
        logger.warn("@aspectStudent Around before pjp.proceed: class = {}", pjp.getSignature().getDeclaringTypeName());
        logger.warn("@aspectStudent Around before pjp.proceed: method = {}", pjp.getSignature().getName());
        logger.warn("@aspectStudent Around before pjp.proceed: args = {}", pjp.getArgs());
        Object obj = pjp.proceed();
        logger.warn("@aspectStudent Around after pjp.proceed: class = {}", pjp.getSignature().getDeclaringTypeName());
        logger.warn("@aspectStudent Around after pjp.proceed: method = {}", pjp.getSignature().getName());
        logger.warn("@aspectStudent Around after pjp.proceed: args = {}", pjp.getArgs());
        return obj;
    }

}
