package com.gy.pj.sys.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.gy.pj.common.exception.ServiceException;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.dao.SysStudentDao;
import com.gy.pj.sys.entity.SysStudent;
import com.gy.pj.sys.service.SysStudentService;

@Service
public class SysStudentServiceImpl implements SysStudentService {

	@Autowired
	private SysStudentDao sysStudentDao;

	@Override
	public PageObject<SysStudent> findPageObjects(String name, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysStudentDao.getRowCount(name);
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysStudent> records = sysStudentDao.findPageObjects(name, startIndex, pageSize);
		return new PageObject<>(pageCurrent, records, rowCount, pageSize);
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
		int rows = sysStudentDao.insertObject(entity);
		return rows;

	}

	@Override
	public int updateObject(SysStudent entity) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		int rows = sysStudentDao.updateObject(entity);
		return rows;
	}

}
