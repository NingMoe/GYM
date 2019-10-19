package com.gy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gy.pj.sys.entity.SysEquipment;

@Mapper
public interface SysEquipmentDao {
	SysEquipment findObjectByName(String ename);
	
	List<SysEquipment> findPageObjects(String ename,Integer startIndex,Integer pageSize);
	
	int getRowCount(String ename);
}
