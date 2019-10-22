package com.gym.service;

import com.gym.entity.SysOrder;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gym.common.vo.PageObject;

public interface SysOrderService {
	int saveObject(SysOrder entity);
	
	List<SysOrder> findObjectByClassname(String userName);

	PageObject<SysOrder> findPageObjects(String class_name,Integer pageCurrent);	

}
