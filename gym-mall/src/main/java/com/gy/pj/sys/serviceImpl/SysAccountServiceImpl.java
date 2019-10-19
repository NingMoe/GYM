package com.gy.pj.sys.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.pj.common.exception.ServiceException;
import com.gy.pj.sys.dao.SysAccountDao;
import com.gy.pj.sys.entity.SysAccount;
import com.gy.pj.sys.service.SysAccountService;
@Service
public class SysAccountServiceImpl implements SysAccountService{
	
	@Autowired
	private SysAccountDao sysAccountDao;
	
	@Override
	public int saveObject(SysAccount entity) {
		int res=sysAccountDao.findObjectByAccount(entity.getAccount());
		if(res!=0) 
			throw new ServiceException("用户名已存在");
		if (entity == null)
			throw new ServiceException("保存数据不能为空");
		if (StringUtils.isEmpty(entity.getAccount()))
			throw new ServiceException("角色名不能为空");
		int rows = sysAccountDao.insertObject(entity);
		return rows;
	}

	@Override
	public int updateObject(SysAccount entity) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		int rows = sysAccountDao.updateObject(entity);
		return rows;
	}

	@Override
	public int login(String account, String pass) {
		int rows=sysAccountDao.login(account, pass);
		if(rows==1)
			return rows;
		else {
			throw new IllegalArgumentException("账号或密码错误");
		}
	}

	/*
	 * @Override 
	 * public int findObjectByAccount(String account) {
	 * 
	 * return 0; }
	 */

}
