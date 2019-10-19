package com.gym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.SysCoachGroupDao;
import com.gym.entity.SysCoachGroup;
import com.gym.exception.ServiceException;
import com.gym.service.SysCoachGroupService;

@Service
public class SysCoachGroupServiceImpl implements SysCoachGroupService {
	@Autowired
	private SysCoachGroupDao sysCoachGroupDao;

	@Override
	public PageInfo<SysCoachGroup> findPageObjects(String tecDirection, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysCoachGroupDao.getRowCount(tecDirection);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		//int pageSize = 3;
		//int startIndex = (pageCurrent - 1) * pageSize;
		PageHelper.startPage(pageCurrent,3);
		List<SysCoachGroup> records = sysCoachGroupDao.findPageObjects(tecDirection);
		PageInfo<SysCoachGroup> pageInfo = new PageInfo<SysCoachGroup>(records);
		pageInfo.setPageNum(pageCurrent);
		return pageInfo;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("至少选择一个");
		int rows;
		try {
			rows = sysCoachGroupDao.deleteObjects(ids);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障，正在恢复中...");
		}
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public int saveObject(SysCoachGroup entity) {
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getTecDirection()))
			throw new ServiceException("组名不能为空");
		int rows;
		try {
			rows = sysCoachGroupDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}

	@Override
	public int updateObject(SysCoachGroup entity) {
		// 1.合法验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getTecDirection()))
			throw new ServiceException("组名不能为空");
		// 2.更新数据
		int rows = sysCoachGroupDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		// 3.返回数据
		return rows;
	}

	@Override
	public SysCoachGroup findById(Integer groupId) {
		SysCoachGroup records = sysCoachGroupDao.findById(groupId);
		return records;
	}
}
