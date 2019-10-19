package com.gy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gy.pj.sys.entity.SysClass;

@Mapper
public interface SysClassDao {
	SysClass findObjectByName(String name);
	
	List<SysClass> findPageObjects(String name,Integer startIndex,Integer pageSize);
	
	int getRowCount(String name);
	
	/*
	 * int insertObject(SysClass entity);
	 * 
	 * int deleteObject(Integer id);
	 * 
	 * int deleteObjects(@Param("ids") Integer... ids);
	 * 
	 * int updateObject(SysClass entity);
	 */
}
