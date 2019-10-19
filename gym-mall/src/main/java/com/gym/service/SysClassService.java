package com.gym.service;

import org.apache.ibatis.annotations.Param;

import com.gym.common.vo.PageObject;
import com.gym.entity.SysClass;

public interface SysClassService {
	/*
	 * int saveObject(SysClass entity);
	 * 
	 * int deleteObject(Integer id); int deleteObjects(@Param("ids") Integer...ids);
	 * 
	 * int updateObject(SysClass entity);
	 */
	SysClass findObjectByName(String name);
	PageObject<SysClass> findPageObjects(String name,Integer pageCurrent);	

}
