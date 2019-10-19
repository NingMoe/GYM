package com.gym.service;

import com.gym.entity.SysClass;
import com.gym.vo.PageObject;

import org.apache.ibatis.annotations.Param;

public interface SysClassService {
	int saveObject(SysClass entity);
	
	int deleteObject(Integer id);
	int deleteObjects(@Param("ids") Integer...ids);
	
	int updateObject(SysClass entity);
	
	SysClass findObjectByName(String name);
	PageObject<SysClass> findPageObjects(String name,Integer pageCurrent);	

}
