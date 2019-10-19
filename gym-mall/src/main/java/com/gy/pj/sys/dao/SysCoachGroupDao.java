package com.gy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gy.pj.sys.entity.SysCoachGroup;

@Mapper
public interface SysCoachGroupDao {
	List<SysCoachGroup> findPageObjects(@Param("tecDirection") String tecDirection,
			@Param("startIndex") Integer startIndex, @Param("pageSize") Integer pageSize);

	int getRowCount(@Param("tecDirection") String tecDirection);

	int deleteObjects(@Param("ids") Integer... ids);

	int insertObject(SysCoachGroup entity);

	int updateObject(SysCoachGroup entity);

	SysCoachGroup findById(Integer groupId);

}
