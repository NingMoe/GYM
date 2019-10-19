package com.gy.pj.sys.service;

import org.apache.ibatis.annotations.Param;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysCmt;

public interface SysCmtService {
	SysCmt findObjectByUsername(String username);
	PageObject<SysCmt> findPageObjects(String username,Integer pageCurrent);	

}
