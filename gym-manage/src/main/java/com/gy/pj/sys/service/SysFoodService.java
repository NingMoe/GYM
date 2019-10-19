package com.gy.pj.sys.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.gy.pj.common.vo.Node;
import com.gy.pj.sys.entity.SysFood;

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
