package com.gym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gym.entity.SysStudent;
@Mapper
public interface SysStudentDao {
    int deleteByPrimaryKey(Integer id);
    int insert(SysStudent entity);
    SysStudent selectByPrimaryKey(Integer id);
    List<SysStudent> selectAll();
    int updateByPrimaryKey(SysStudent entity);
    
    List<SysStudent> findPageObjects(@Param("name") String name);
    int getRowCount(@Param("name") String name);
    int deleteObjects(@Param("ids")Integer... ids);
    SysStudent findById(Integer id);
}