package com.gym.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.SysAccountDao;
import com.gym.entity.SysAccount;
import com.gym.exception.ServiceException;
import com.gym.service.SysAccountService;
@Service
public class SysAccountServiceImpl implements SysAccountService{
	
	@Autowired
	private SysAccountDao sysAccountDao;
	
	@Override
	public PageInfo<SysAccount> findPageObjects(String name, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysAccountDao.getRowCount(name);
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		PageHelper.startPage(pageCurrent,3);
		List<SysAccount> records = sysAccountDao.findPageObjects(name);
		PageInfo<SysAccount> pageInfo = new PageInfo<SysAccount>(records);
		pageInfo.setPageNum(pageCurrent);
		return pageInfo;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("请选择一个");
		int rows;
		try {
			rows = sysAccountDao.deleteObjects(ids);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障，正在恢复中...");
		}
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public int saveObject(SysAccount entity) {
		if (entity == null)
			throw new ServiceException("保存数据不能为空");
		if (StringUtils.isEmpty(entity.getName()))
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
	public SysAccount findById(Integer id) {
		SysAccount records = sysAccountDao.findById(id);
		return records;
	}

}
