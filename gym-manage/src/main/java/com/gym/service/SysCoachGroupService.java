package com.gym.service;

import com.github.pagehelper.PageInfo;
import com.gym.entity.SysCoachGroup;

public interface SysCoachGroupService {
	PageInfo<SysCoachGroup> findPageObjects(String tecDirection, Integer pageCurrent);

	int deleteObjects(Integer... ids);
	
	int saveObject(SysCoachGroup entity);
	
	int updateObject(SysCoachGroup entity);

	SysCoachGroup findById(Integer groupId);
}
