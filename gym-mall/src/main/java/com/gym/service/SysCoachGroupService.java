package com.gym.service;

import com.gym.common.vo.PageObject;
import com.gym.entity.SysCoachGroup;

public interface SysCoachGroupService {
	PageObject<SysCoachGroup> findPageObjects(String tecDirection, Integer pageCurrent);

	int deleteObjects(Integer... ids);
	
	int saveObject(SysCoachGroup entity);
	
	int updateObject(SysCoachGroup entity);

	SysCoachGroup findById(Integer groupId);
}
