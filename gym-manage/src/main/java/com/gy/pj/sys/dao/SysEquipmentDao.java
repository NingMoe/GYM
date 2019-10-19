package com.gy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gy.pj.sys.entity.SysEquipment;

@Mapper
public interface SysEquipmentDao {
	int getRowCount(@Param("ename") String ename);
	List<SysEquipment> findObject(@Param("ename") String ename);
	int deleteObjects(@Param("ids") Integer...ids);
	int insertObjects(SysEquipment entity);
	int updataObjects(SysEquipment entity);
}
