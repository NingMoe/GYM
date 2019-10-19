package com.gy.pj.sys.service;

import com.github.pagehelper.PageInfo;
import com.gy.pj.sys.entity.SysAccount;

public interface SysAccountService {
	PageInfo<SysAccount> findPageObjects(String name, Integer pageCurrent);
	int deleteObjects(Integer... ids);
	int saveObject(SysAccount entity);
	int updateObject(SysAccount entity);
	SysAccount findById(Integer id);
}
