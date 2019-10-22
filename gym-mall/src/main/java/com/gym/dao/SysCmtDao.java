package com.gym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gym.entity.SysCmt;
@Mapper
public interface SysCmtDao {
	SysCmt findObjectByUsername(String username);
	
	List<SysCmt> findPageObjects(String username,Integer startIndex,Integer pageSize);
	
	int getRowCount(String username);
	
	int insertObject(SysCmt entity);
	
	int deleteObject(Integer id);
	
	int deleteObjects(@Param("ids") Integer... ids);
}
