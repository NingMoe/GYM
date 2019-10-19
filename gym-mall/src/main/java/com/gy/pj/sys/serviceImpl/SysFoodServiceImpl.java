package com.gy.pj.sys.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.dao.SysFoodDao;
import com.gy.pj.sys.entity.SysFood;
import com.gy.pj.sys.service.SysFoodService;
@Service
public class SysFoodServiceImpl implements SysFoodService {

@Autowired
private SysFoodDao sysFoodDao;

	@Override
	public PageObject<SysFood> findFoodObjects(String food, Integer pageCurrent) {
		//1.对参数进行校验
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数并进行校验
		int rowCount=sysFoodDao.getRowCount(food);
//		if(rowCount==0)
//		throw new ServiceException("没有找到对应记录");
		//3.查询当前页记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysFood> records = sysFoodDao.findFoodObject(food, startIndex, pageSize);
		//4.对查询结果进行封装并返回
		return new PageObject<>(pageCurrent, records, rowCount, pageSize);
	}

}
