package com.gy.pj.sys.service;

import org.apache.ibatis.annotations.Param;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysUser;

public interface SysUserService {
	int saveObject(SysUser entity);
	
	int deleteObject(Integer id);
	int deleteObjects(@Param("ids") Integer...ids);
	
	int updateObject(SysUser entity);
	
	SysUser findObjectByUsername(String username);
	PageObject<SysUser> findPageObjects(String username,Integer pageCurrent);	

}
