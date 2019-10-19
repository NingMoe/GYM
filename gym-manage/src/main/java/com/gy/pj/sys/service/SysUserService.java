package com.gy.pj.sys.service;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.gy.pj.sys.entity.SysUser;

public interface SysUserService {
	int saveObject(SysUser entity);

	int deleteObject(Integer id);

	int deleteObjects(@Param("ids") Integer... ids);

	int updateObject(SysUser entity);

	SysUser findObjectByUsername(String username);

	PageInfo<SysUser> findPageObjects(String username, Integer pageCurrent);

	int validById(Integer id, Integer valid, String modifiedUser);

}
