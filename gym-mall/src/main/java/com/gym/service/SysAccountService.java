package com.gym.service;

import com.github.pagehelper.PageInfo;
import com.gym.entity.SysAccount;

public interface SysAccountService {
	int saveObject(SysAccount entity);
	int updateObject(SysAccount entity);
	int login(String account,String pass);
//	public int findObjectByAccount(String account);
}
