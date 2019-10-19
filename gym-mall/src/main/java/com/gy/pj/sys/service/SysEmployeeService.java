package com.gy.pj.sys.service;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysEmployee;

public interface SysEmployeeService {
	/**
	 * 通过此方法实现分页查询操作
	 * @param name 基于条件查询时的参数名
	 * @param pageCurrent 当前的页码值
	 * @return 当前页记录+分页信息
	 */
	PageObject<SysEmployee> findObject(String name,Integer pageCurrent);
   int deleteObject(Integer ...ids);
}
