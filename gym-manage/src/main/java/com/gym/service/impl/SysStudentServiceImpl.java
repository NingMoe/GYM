package com.gym.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.SysStudentDao;
import com.gym.entity.SysStudent;
import com.gym.exception.ServiceException;
import com.gym.service.SysStudentService;

@Service
public class SysStudentServiceImpl implements SysStudentService {

	@Autowired
	private SysStudentDao sysStudentDao;

	@Override
	public PageInfo<SysStudent> findPageObjects(String name, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysStudentDao.getRowCount(name);
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		PageHelper.startPage(pageCurrent,3);
		List<SysStudent> records = sysStudentDao.findPageObjects(name);
		PageInfo<SysStudent> pageInfo = new PageInfo<SysStudent>(records);
		pageInfo.setPageNum(pageCurrent);
		return pageInfo;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("请选择一个");
		int rows;
		try {
			rows = sysStudentDao.deleteObjects(ids);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障，正在恢复中...");
		}
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public int saveObject(SysStudent entity) {
		if (entity == null)
			throw new ServiceException("保存数据不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("角色名不能为空");
		int rows = sysStudentDao.insert(entity);
		return rows;

	}

	@Override
	public int updateObject(SysStudent entity) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		int rows = sysStudentDao.updateByPrimaryKey(entity);
		return rows;
	}

	@Override
	public SysStudent findById(Integer id) {
		SysStudent records = sysStudentDao.findById(id);
		return records;
	}

}
