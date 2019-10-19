package com.gym.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.dao.SysFoodDao;
import com.gym.entity.SysFood;
import com.gym.exception.ServiceException;
import com.gym.service.SysFoodService;
import com.gym.vo.Node;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class SysFoodServiceImpl implements SysFoodService {

	@Autowired
	private SysFoodDao sysFoodDao;


	@Override
	public int deleteByIds(Integer... ids) {
		if (ids==null||ids.length==0)
			throw new IllegalArgumentException("无效的id");
		int rows = sysFoodDao.deleteObjects(ids);
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public int insertObject(SysFood entity) {
		//1.参数校验
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getFood()))
			throw new IllegalArgumentException("食材名不能为空");
		//......
		//2.保存菜单对象
		int rows=0;
		try {
			rows = sysFoodDao.insertObjects(entity);
		}catch(Throwable e) {//了解
			log.error(e.getMessage());
			//报警
			throw new ServiceException("系统维护中");
		}
		//3.返回结果
		return rows;

	}

	@Override
	public int updataObject(SysFood entity) {
		int rows = sysFoodDao.updataObjects(entity);
		return rows;
	}

	@Override
	public PageInfo<SysFood> findFoodObjects(String food, Integer pageCurrent) {
				if(pageCurrent==null||pageCurrent<1)
					throw new IllegalArgumentException("当前页码值无效");
				int rowCount=sysFoodDao.getRowCount(food);
				if(rowCount==0)
					throw new ServiceException("没有找到对应记录");
				PageHelper.startPage(pageCurrent,3); 
				
				List<SysFood> records = sysFoodDao.findObject(food);
				
				PageInfo<SysFood> pageInfo = new PageInfo<SysFood>(records);
				pageInfo.setPageNum(pageCurrent);
				return pageInfo;
	}

	@Override
	public List<Node> findFoodAndList() {
		List<Node> findfoodsAndHeat = sysFoodDao.findfoodsAndHeat();
		return findfoodsAndHeat;
	}

	@Override
	public List<SysFood> findAll() {
		List<SysFood> findALl = sysFoodDao.findALl();
		return findALl;
	}
}
