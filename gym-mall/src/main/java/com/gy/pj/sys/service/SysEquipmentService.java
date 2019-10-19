package com.gy.pj.sys.service;

import org.apache.ibatis.annotations.Param;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysEquipment;

public interface SysEquipmentService {
	SysEquipment findObjectByName(String ename);
	PageObject<SysEquipment> findPageObjects(String ename,Integer pageCurrent);	

}
