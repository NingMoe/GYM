package com.gy.pj.sys.service;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysStudent;

public interface SysStudentService {
	PageObject<SysStudent> findPageObjects(String name, Integer pageCurrent);
	int deleteObjects(Integer... ids);
	int saveObject(SysStudent entity);
	int updateObject(SysStudent entity);
}
