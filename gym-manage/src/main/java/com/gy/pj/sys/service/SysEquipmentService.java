package com.gy.pj.sys.service;

import com.github.pagehelper.PageInfo;
import com.gy.pj.sys.entity.SysEquipment;

public interface SysEquipmentService {
	
	PageInfo<SysEquipment> findEquipmentObjects(
			 String ename,
			 Integer pageCurrent);
	
	 int deleteByIds(Integer... ids);
	 
	 int insertObject(SysEquipment entity);
	 
	 
	 int updataObject(SysEquipment entity);

}
