package com.gy.pj.sys.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gy.pj.common.exception.ServiceException;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.dao.SysOrderDao;
import com.gy.pj.sys.entity.SysClass;
import com.gy.pj.sys.entity.SysOrder;
import com.gy.pj.sys.service.SysOrderService;

@Service
public class SysOrderServiceImpl implements SysOrderService{
	@Autowired
	private SysOrderDao sysOrderDao;

	@Override
	public List<SysOrder> findObjectByClassname(String userName) {
		//1.合法性验证
		if(userName==null)
			throw new ServiceException("name的值不合法");
		//2.执行查询
		List<SysOrder> result=sysOrderDao.findObjectByClassName(userName);
		//3.验证结果并返回
		if(result==null)
			throw new ServiceException("此记录已经不存在");
		return result;
	}

	@Override
	public PageObject<SysOrder> findPageObjects(String class_name, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		int rowCount = sysOrderDao.getRowCount(class_name);
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		int pageSize = 5;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysOrder> records = sysOrderDao.findPageObjects(class_name, startIndex, pageSize);
		PageObject<SysOrder> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		return pageObject;
	}

	@Override
	public int saveObject(SysOrder entity) {
		//1.合法性验证
		if(entity==null)
			throw new ServiceException("保存数据不能为空");
		if(StringUtils.isEmpty(entity.getClassName()))
			throw new ServiceException("课程名不能为空");
		//2.保存数据
		int rows=sysOrderDao.insertObject(entity);
		//3.返回结果
		return rows;
	}


}
