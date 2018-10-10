package com.draper.service.impl;

import com.draper.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));

    @Override
    public void taskOne() {
        System.out.println("执行方法");
        for (int i = 0; i < 100000; i++) {
            logger.warn("i = {}", i);
        }
    }
}
