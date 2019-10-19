package com.gym.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.SysEmployeeDao;
import com.gym.entity.SysEmployee;
import com.gym.exception.ServiceException;
import com.gym.service.SysEmployeeService;




@Service
public class SysEmployeeServiceImpl implements SysEmployeeService {
	@Autowired
	private SysEmployeeDao sysEmployeeDao;

	@Override
	public PageInfo<SysEmployee> findObject(String name, Integer pageCurrent) {
		// 1.验证参数合法性
		// 1.1验证pageCurrent的合法性，
		// 不合法抛出IllegalArgumentException异常
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		// 2.基于条件查询总记录数
		// 2.1) 执行查询
		int rowCount = sysEmployeeDao.getRowCount(name);
		// 2.2) 验证查询结果，假如结果为0不再执行如下操作
		if (rowCount == 0)
			throw new ServiceException("系统没有查到对应记录");
		// 3.基于条件查询当前页记录(pageSize定义为2)
		// 3.1)定义pageSize
		//int pageSize = 2;
		// 3.2)计算startIndex
		//int startIndex = (pageCurrent - 1) * pageSize;
		// 3.3)执行当前数据的查询操作
		PageHelper.startPage(pageCurrent,3);
		List<SysEmployee> records = sysEmployeeDao.findObject(name);
		PageInfo<SysEmployee> pageInfo = new	PageInfo<SysEmployee>(records);
		pageInfo.setPageNum(pageCurrent);
		//List<SysEmployee> records = sysEmployeeDao.findObject(name, startIndex, pageSize);
		// 4.对分页信息以及当前页记录进行封装
		// 4.1)构建PageObject对象

		// 4.2)封装数据

		// 5.返回封装结果。
		return pageInfo;
		///return  new PageObject<>(pageCurrent, records, rowCount, pageSize);
	}

	@Override
	public int deleteObject(Integer... ids) {
		// 1.判定参数合法性
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("请选择一个");
		// 2.执行删除操作
		int rows;
		try {
			rows = sysEmployeeDao.deleteObject(ids);
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
	public int saveObject(SysEmployee entity) {
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("姓名不能为空");
		int rows;
		try {
			rows = sysEmployeeDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		return rows;
	}

	@Override
	public int updateObject(SysEmployee entity) {
		// 1.合法验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("姓名不能为空");
		// 2.更新数据
		int rows = sysEmployeeDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		// 3.返回数据
		return rows;
	}

	@Override
	public SysEmployee findById(Integer Id) {
		SysEmployee records = sysEmployeeDao.findById(Id);
		return records;
	}

	@Override
	public List<SysEmployee> findAllObject() {
		return sysEmployeeDao.findAllObject();
	}
	@Override
	public void changeAvatar(Integer Id, String avatar) {
		// 使用uid查询用户数据
		SysEmployee emp=sysEmployeeDao.findById(Id);
		// 判断返回结果是否为null
		if(emp ==null) {
			// 是：UserNotFoundException
			throw new ServiceException("上传头像异常！用户数据不存在");
		}

		//Date modifiedTime = null;
		// 判断isDelete是否为1
		/*
		 * Integer rows = sysEmployeeDao.updateAvatar(Id, avatar); if(rows == 0) { //
		 * 是：UserNotFoundException throw new ServiceException("上传头像异常！用户数据不存在"); }
		 */

		// 更新用户头像
		Integer row=sysEmployeeDao.updateAvatar(Id, avatar);
		// 判断受影响的行数是否不为1
		if(!row.equals(1)) {
			// 是：UpdateException
			throw new ServiceException("上传头像异常！请联系管理员");
		}
	}
}


