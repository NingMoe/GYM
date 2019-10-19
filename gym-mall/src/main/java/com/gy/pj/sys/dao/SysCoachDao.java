package com.gy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gy.pj.sys.entity.SysCoach;

@Mapper
public interface SysCoachDao {
	List<SysCoach> findPageObjects(@Param("name") String name, @Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize);
	int getRowCount(@Param("name") String name);
}
