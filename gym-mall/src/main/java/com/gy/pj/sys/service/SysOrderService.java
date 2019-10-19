package com.gy.pj.sys.service;

import com.gy.pj.sys.entity.SysOrder;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gy.pj.common.vo.PageObject;

public interface SysOrderService {
	int saveObject(SysOrder entity);
	
	List<SysOrder> findObjectByClassname(String userName);

	PageObject<SysOrder> findPageObjects(String class_name,Integer pageCurrent);	

}
