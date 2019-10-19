package com.gy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gy.pj.sys.entity.SysCoach;

@Mapper
public interface SysCoachDao {
	List<SysCoach> findPageObjects(@Param("name") String name);

	int getRowCount(@Param("name") String name);

	int deleteObjects(@Param("ids") Integer... ids);

	int insertObject(SysCoach entity);

	int updateObject(SysCoach entity);

	SysCoach findById(Integer groupId);


	Integer updateAvatar(Integer id, String avatar);
}
