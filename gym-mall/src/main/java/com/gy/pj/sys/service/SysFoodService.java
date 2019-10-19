package com.gy.pj.sys.service;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysFood;

public interface SysFoodService {
	
	 PageObject<SysFood> findFoodObjects(
			 String food,
			 Integer pageCurrent);
	
}
