package com.gy.pj.sys.dao;

import com.gy.pj.sys.entity.TestMybatis;
import java.util.List;

public interface TestMybatisMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestMybatis record);

    TestMybatis selectByPrimaryKey(Integer id);

    List<TestMybatis> selectAll();

    int updateByPrimaryKey(TestMybatis record);
}