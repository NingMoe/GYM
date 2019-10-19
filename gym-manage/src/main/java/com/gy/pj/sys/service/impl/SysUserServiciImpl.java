package com.gy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.pj.common.exception.ServiceException;

import com.gy.pj.sys.dao.SysUserDao;

import com.gy.pj.sys.entity.SysUser;
import com.gy.pj.sys.service.SysUserService;

@Service
public class SysUserServiciImpl implements SysUserService {
	@Autowired
	private SysUserDao sysUserDao;

	@Override
	public int saveObject(SysUser entity) {
		// 1.合法性验证
		if (entity == null)
			throw new ServiceException("保存数据不能为空");
		if (StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("课程名不能为空");
		// 2.保存数据
		int rows = sysUserDao.insertObject(entity);
		// 3.返回结果
		return rows;
	}

	@Override
	public int deleteObject(Integer id) {
		// 1.判定参数合法性
		if (id == null || id <= 0)
			throw new IllegalArgumentException("请选择一个");
		// 2.执行删除操作
		int rows;
		try {
			rows = sysUserDao.deleteObjects(id);
		} catch (Throwable e) {
			e.printStackTrace();
			// 发出报警信息(例如给运维人员发短信)
			throw new ServiceException("系统故障，正在恢复中...");
		}
		// 4.对结果进行验证
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		// 5.返回结果
		return rows;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		// 1.判定参数合法性
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("请选择一个");
		// 2.执行删除操作
		int rows;
		try {
			rows = sysUserDao.deleteObjects(ids);
		} catch (Throwable e) {
			e.printStackTrace();
			// 发出报警信息(例如给运维人员发短信)
			throw new ServiceException("系统故障，正在恢复中...");
		}
		// 4.对结果进行验证
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		// 5.返回结果
		return rows;
	}

	@Override
	public int updateObject(SysUser entity) {
		// 1.合法性验证
		if (entity == null)
			throw new ServiceException("更新的对象不能为空");

		if (StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("角色名不能为空");

		// 2.更新数据
		int rows = sysUserDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("对象可能已经不存在");
		// sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		// sysRoleMenuDao.insertObject(entity.getId(),menuIds);

		// 3.返回结果
		return rows;
	}

	@Override
	public SysUser findObjectByUsername(String username) {
		// 1.合法性验证
		if (username == null)
			throw new ServiceException("name的值不合法");
		// 2.执行查询
		SysUser result = sysUserDao.findObjectByUsername(username);
		// 3.验证结果并返回
		if (result == null)
			throw new ServiceException("此记录已经不存在");
		return result;
	}

	@Override
	public PageInfo<SysUser> findPageObjects(String username, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysUserDao.getRowCount(username);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		// int pageSize = 3;
		// int startIndex = (pageCurrent - 1) * pageSize;
		PageHelper.startPage(pageCurrent, 3);
		List<SysUser> records = sysUserDao.findPageObjects(username);
		PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(records);
		pageInfo.setPageNum(pageCurrent);
		return pageInfo;
	}

	@Override
	public int validById(Integer id, Integer valid, String modifiedUser) {
		if (id == null || id <= 0)
			throw new ServiceException("参数不合法,id=" + id);
		if (valid != 1 && valid != 0)
			throw new ServiceException("参数不合法,valie=" + valid);
		if (StringUtils.isEmpty(modifiedUser))
			throw new ServiceException("修改用户不能为空");
		// 2.执行禁用或启用操作
		int rows = 0;
		try {
			rows = sysUserDao.validById(id, valid, modifiedUser);
		} catch (Throwable e) {
			e.printStackTrace();
			// 报警,给维护人员发短信
			throw new ServiceException("底层正在维护");
		}
		// 3.判定结果,并返回
		if (rows == 0)
			throw new ServiceException("此记录可能已经不存在");
		return rows;
	}

}
