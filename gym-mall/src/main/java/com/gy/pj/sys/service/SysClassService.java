package com.gy.pj.sys.service;

import org.apache.ibatis.annotations.Param;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysClass;

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
