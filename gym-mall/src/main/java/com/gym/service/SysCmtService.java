package com.gym.service;

import org.apache.ibatis.annotations.Param;

import com.gym.common.vo.PageObject;
import com.gym.entity.SysCmt;

public interface SysCmtService {
	SysCmt findObjectByUsername(String username);
	PageObject<SysCmt> findPageObjects(String username,Integer pageCurrent);	

}
