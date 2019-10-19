package com.gy.pj.sys.service;


import com.github.pagehelper.PageInfo;
import com.gy.pj.common.exception.ServiceException;
import com.gy.pj.sys.entity.SysCoach;

public interface SysCoachService {
	PageInfo<SysCoach> findPageObjects(String name, Integer pageCurrent);
	int deleteObjects(Integer... ids);
	int saveObject(SysCoach entity);
	int updateObject(SysCoach entity);

	SysCoach findById(Integer groupId);
	void changeAvatar (Integer id,String avatar)throws ServiceException;
}
