package com.gy.pj.sys.service;

import com.github.pagehelper.PageInfo;
import com.gy.pj.sys.entity.SysAccount;

public interface SysAccountService {
	int saveObject(SysAccount entity);
	int updateObject(SysAccount entity);
	int login(String account,String pass);
//	public int findObjectByAccount(String account);
}
