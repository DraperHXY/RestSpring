package com.draper.mapper;

import com.draper.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMapperTest extends BaseTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void testSelectPeopleByName(){

        List<com.draper.entity.Test> tests = testMapper.selectPeopleByName("'Draper' OR 1=1");

        for (int i = 0; i < tests.size(); i++) {
            System.out.println(tests.get(i).getName());
            System.out.println(tests.get(i).getMoney());
        }

    }


}
