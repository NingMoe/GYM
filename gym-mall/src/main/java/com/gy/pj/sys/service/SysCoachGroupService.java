package com.gy.pj.sys.service;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysCoachGroup;

public interface SysCoachGroupService {
	PageObject<SysCoachGroup> findPageObjects(String tecDirection, Integer pageCurrent);

	int deleteObjects(Integer... ids);
	
	int saveObject(SysCoachGroup entity);
	
	int updateObject(SysCoachGroup entity);

	SysCoachGroup findById(Integer groupId);
}
