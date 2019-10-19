package com.gy.pj.sys.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gy.pj.common.exception.ServiceException;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.dao.SysCmtDao;
import com.gy.pj.sys.entity.SysClass;
import com.gy.pj.sys.entity.SysCmt;
import com.gy.pj.sys.service.SysClassService;
import com.gy.pj.sys.service.SysCmtService;

@Service
public class SysCmtServiceImpl implements SysCmtService{
	@Autowired
	private SysCmtService sysCmtService;
	@Autowired
	private SysCmtDao sysCmtDao;


	@Override
	public SysCmt findObjectByUsername(String username) {
		//1.合法性验证
		if(username==null)
			throw new ServiceException("name的值不合法");
		//2.执行查询
		SysCmt result=sysCmtDao.findObjectByUsername(username);
		//3.验证结果并返回
		if(result==null)
			throw new ServiceException("此记录已经不存在");
		return result;
	}

	@Override
	public PageObject<SysCmt> findPageObjects(String username, Integer pageCurrent) {
		// 1.验证参数合法性
		// 1.1验证pageCurrent的合法性，
		// 不合法抛出IllegalArgumentException异常
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		// 2.基于条件查询总记录数
		// 2.1) 执行查询
		int rowCount = sysCmtDao.getRowCount(username);
		// 2.2) 验证查询结果，假如结果为0不再执行如下操作
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		// 3.基于条件查询当前页记录(pageSize定义为2)
		// 3.1)定义pageSize
		int pageSize = 15;
		// 3.2)计算startIndex
		int startIndex = (pageCurrent - 1) * pageSize;
		// 3.3)执行当前数据的查询操作
		List<SysCmt> records = sysCmtDao.findPageObjects(username, startIndex, pageSize);
		// 4.对分页信息以及当前页记录进行封装
		// 4.1)构建PageObject对象
		PageObject<SysCmt> pageObject = new PageObject<>();
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
