package com.draper.mapper;

import com.draper.entity.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {

    List<Test> selectPeopleByName(@Param(value = "name") String name);

}
