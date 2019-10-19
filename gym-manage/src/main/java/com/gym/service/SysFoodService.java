package com.gym.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.gym.entity.SysFood;
import com.gym.vo.Node;

public interface SysFoodService {
	
	PageInfo<SysFood> findFoodObjects(
			 String food,
			 Integer pageCurrent);
	
	 int deleteByIds(Integer... ids);
	 
	 int insertObject(SysFood entity);
	 
	 
	 int updataObject(SysFood entity);
	 
	 List<Node> findFoodAndList();
	 List<SysFood> findAll();
}
