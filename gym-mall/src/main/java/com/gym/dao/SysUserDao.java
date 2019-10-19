package com.gym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gym.entity.SysUser;

@Mapper
public interface SysUserDao {
	SysUser findObjectByUsername(String username);
	
	List<SysUser> findPageObjects(String username,Integer startIndex,Integer pageSize);
	
	int getRowCount(String username);
	
	int insertObject(SysUser entity);
	
	int deleteObject(Integer id);
	
	int deleteObjects(@Param("ids") Integer... ids);

	int updateObject(SysUser entity);
}
