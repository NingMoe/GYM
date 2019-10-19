package com.gy.pj.sys.service;
import com.github.pagehelper.PageInfo;
import com.gy.pj.sys.entity.SysStudent;

public interface SysStudentService {
	PageInfo<SysStudent> findPageObjects(String name, Integer pageCurrent);
	int deleteObjects(Integer... ids);
	int saveObject(SysStudent record);
	int updateObject(SysStudent record);
	SysStudent findById(Integer id);
}
