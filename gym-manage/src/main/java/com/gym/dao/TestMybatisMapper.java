package com.gym.dao;

import java.util.List;

import com.gym.entity.TestMybatis;

public interface TestMybatisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestMybatis record);

    TestMybatis selectByPrimaryKey(Integer id);

    List<TestMybatis> selectAll();

    int updateByPrimaryKey(TestMybatis record);
}