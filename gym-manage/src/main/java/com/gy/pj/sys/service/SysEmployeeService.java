package com.gy.pj.sys.service;


import java.util.List;
import com.github.pagehelper.PageInfo;
import com.gy.pj.common.exception.ServiceException;
import com.gy.pj.sys.entity.SysEmployee;
public interface SysEmployeeService {
	/**
	 * 通过此方法实现分页查询操作
	 * @param name 基于条件查询时的参数名
	 * @param pageCurrent 当前的页码值
	 * @return 当前页记录+分页信息
	 */
	PageInfo<SysEmployee> findObject(String name,Integer pageCurrent);
	int deleteObject(Integer ...ids);
	/**更新用户以及用户和角色关系数据*/
	int saveObject(SysEmployee entity);
	int updateObject(SysEmployee entity);
	SysEmployee findById(Integer Id);
	List<SysEmployee> findAllObject();
	/**
	 * 更新用户头像
	 * @param uid 用户id
	 * @param avatar 头像路径
	 * @param modifiedUser 最后修改用户
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeAvatar (Integer Id,String avatar)throws ServiceException;
	
}
