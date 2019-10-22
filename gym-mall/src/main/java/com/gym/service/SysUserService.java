package com.gym.service;

import org.apache.ibatis.annotations.Param;

import com.gym.common.vo.PageObject;
import com.gym.entity.SysUser;

public interface SysUserService {
	int saveObject(SysUser entity);
	
	int deleteObject(Integer id);
	int deleteObjects(@Param("ids") Integer...ids);
	
	int updateObject(SysUser entity);
	
	SysUser findObjectByUsername(String username);
	PageObject<SysUser> findPageObjects(String username,Integer pageCurrent);	

}
