package com.gym.service;


import com.github.pagehelper.PageInfo;
import com.gym.entity.SysCoach;
import com.gym.exception.ServiceException;

public interface SysCoachService {
	PageInfo<SysCoach> findPageObjects(String name, Integer pageCurrent);
	int deleteObjects(Integer... ids);
	int saveObject(SysCoach entity);
	int updateObject(SysCoach entity);

	SysCoach findById(Integer groupId);
	void changeAvatar (Integer id,String avatar)throws ServiceException;
}
