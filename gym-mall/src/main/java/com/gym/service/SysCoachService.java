package com.gym.service;

import com.gym.common.vo.PageObject;
import com.gym.entity.SysCoach;

public interface SysCoachService {
	PageObject<SysCoach> findPageObjects(String name, Integer pageCurrent);
}
