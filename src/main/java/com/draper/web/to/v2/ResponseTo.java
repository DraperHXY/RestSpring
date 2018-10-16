package com.draper.web.to.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ResponseTo {

    private Logger logger = LoggerFactory.getLogger(String.valueOf(this));


    @Autowired
    public MessageSource messageSource;

    public Map msg(String msg)  {

        //args 作为在 properties 文件中占位符的实际值，根据 locale 划分的地区找到指定 msg 将 args 填入
        String error = messageSource.getMessage(msg, null, null);
        logger.warn("error = {}", error);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = null;
        try {
            map = objectMapper.readValue(error, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Map msg(String msg, Object data)  {
        String error = messageSource.getMessage(msg, null, null);
        logger.warn("error = {}", error);

        ObjectMapper objectMapper = new ObjectMapper();
        Map map = null;
        try {
            map = objectMapper.readValue(error, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("data", data);
        return map;

    }
}
