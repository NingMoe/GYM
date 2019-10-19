package com.gym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.SysEquipmentDao;
import com.gym.entity.SysEquipment;
import com.gym.exception.ServiceException;
import com.gym.service.SysEquipmentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SysEquipmentServiceImpl implements SysEquipmentService{

	@Autowired
	private SysEquipmentDao sysEquipmentDao;

	@Override
	public int deleteByIds(Integer... ids) {
		if (ids==null||ids.length==0)
			throw new IllegalArgumentException("无效的id");
		int rows = sysEquipmentDao.deleteObjects(ids);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}
	@Override
	public int insertObject(SysEquipment entity) {
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getEname()))
			throw new IllegalArgumentException("器材名不能为空");
		int rows=0;
		try {
			rows = sysEquipmentDao.insertObjects(entity);
		}catch(Throwable e) {
			log.error(e.getMessage());
			throw new ServiceException("系统维护中");
		}
		return rows;
	}
	@Override
	public int updataObject(SysEquipment entity) {
		int rows = sysEquipmentDao.updataObjects(entity);
		return rows;
	}

	@Override
	public PageInfo<SysEquipment> findEquipmentObjects(String ename, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值无效");
		int rowCount=sysEquipmentDao.getRowCount(ename);
		if(rowCount==0)
			throw new ServiceException("没有找到对应记录");
		PageHelper.startPage(pageCurrent,3); 
		List<SysEquipment> records = sysEquipmentDao.findObject(ename);
		PageInfo<SysEquipment> pageInfo = new PageInfo<SysEquipment>(records);
		pageInfo.setPageNum(pageCurrent);
		return pageInfo;
	}

}
