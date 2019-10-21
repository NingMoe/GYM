package com.gym.service;

import com.gym.common.vo.PageObject;
import com.gym.entity.SysFood;

public interface SysFoodService {
	
	 PageObject<SysFood> findFoodObjects(
			 String food,
			 Integer pageCurrent);
	
}
