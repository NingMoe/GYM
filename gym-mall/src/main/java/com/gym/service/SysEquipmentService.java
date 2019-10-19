package com.gym.service;

import org.apache.ibatis.annotations.Param;

import com.gym.common.vo.PageObject;
import com.gym.entity.SysEquipment;

public interface SysEquipmentService {
	SysEquipment findObjectByName(String ename);
	PageObject<SysEquipment> findPageObjects(String ename,Integer pageCurrent);	

}
