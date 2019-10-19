package com.gy.pj.sys.service;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysCoach;

public interface SysCoachService {
	PageObject<SysCoach> findPageObjects(String name, Integer pageCurrent);
}
