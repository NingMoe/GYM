package com.gy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gy.pj.common.exception.ServiceException;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.dao.SysClassDao;
import com.gy.pj.sys.entity.SysClass;
import com.gy.pj.sys.service.SysClassService;

@Service
public class SysClassServiceImpl implements SysClassService{
	@Autowired
	private SysClassDao sysClassDao;

	@Override
	public int saveObject(SysClass entity) {
		//1.合法性验证
		if(entity==null)
			throw new ServiceException("保存数据不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("课程名不能为空");
		//2.保存数据
		int rows=sysClassDao.insertObject(entity);
		//3.返回结果
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
			rows = sysClassDao.deleteObjects(id);
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
			rows = sysClassDao.deleteObjects(ids);
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
	public int updateObject(SysClass entity) {
		//1.合法性验证
		if(entity==null)
			throw new ServiceException("更新的对象不能为空");

		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("角色名不能为空");

		//2.更新数据
		int rows=sysClassDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("对象可能已经不存在");
		//	sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		//	sysRoleMenuDao.insertObject(entity.getId(),menuIds);

		//3.返回结果
		return rows;
	}

	@Override
	public SysClass findObjectByName(String name) {
		//1.合法性验证
		if(name==null)
			throw new ServiceException("name的值不合法");
		//2.执行查询
		SysClass result=sysClassDao.findObjectByName(name);
		//3.验证结果并返回
		if(result==null)
			throw new ServiceException("此记录已经不存在");
		return result;
	}

	@Override
	public PageObject<SysClass> findPageObjects(String name, Integer pageCurrent) {
		// 1.验证参数合法性
		// 1.1验证pageCurrent的合法性，
		// 不合法抛出IllegalArgumentException异常
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		// 2.基于条件查询总记录数
		// 2.1) 执行查询
		int rowCount = sysClassDao.getRowCount(name);
		// 2.2) 验证查询结果，假如结果为0不再执行如下操作
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		// 3.基于条件查询当前页记录(pageSize定义为2)
		// 3.1)定义pageSize
		int pageSize = 5;
		// 3.2)计算startIndex
		int startIndex = (pageCurrent - 1) * pageSize;
		// 3.3)执行当前数据的查询操作
		List<SysClass> records = sysClassDao.findPageObjects(name, startIndex, pageSize);
		// 4.对分页信息以及当前页记录进行封装
		// 4.1)构建PageObject对象
		PageObject<SysClass> pageObject = new PageObject<>();
		// 4.2)封装数据
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		// 5.返回封装结果。
		return pageObject;
	}


}
