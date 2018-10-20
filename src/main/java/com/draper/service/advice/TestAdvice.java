package com.draper.service.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

public class TestAdvice implements MethodBeforeAdvice {

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Override
    public void before(Method method, Object[] objects, @Nullable Object o) throws Throwable {
        logger.warn("test advice success");
    }

}
