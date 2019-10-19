package com.gym.service;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysStudent;

public interface SysStudentService {
	PageObject<SysStudent> findPageObjects(String name, Integer pageCurrent);
	int deleteObjects(Integer... ids);
	int saveObject(SysStudent entity);
	int updateObject(SysStudent entity);
}
