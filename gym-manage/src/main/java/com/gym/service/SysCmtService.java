package com.gym.service;

import org.apache.ibatis.annotations.Param;

import com.gym.entity.SysCmt;
import com.gym.vo.PageObject;

public interface SysCmtService {
	int saveObject(SysCmt entity);
	
	int deleteObject(Integer id);
	int deleteObjects(@Param("ids") Integer...ids);
	
	SysCmt findObjectByUsername(String username);
	PageObject<SysCmt> findPageObjects(String username,Integer pageCurrent);	

}
