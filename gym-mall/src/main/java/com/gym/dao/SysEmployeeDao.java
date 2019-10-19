package com.gym.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gym.entity.SysEmployee;


@Mapper
public interface SysEmployeeDao {
	/**
	 * 将用户行为日志写入到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysEmployee entity);
	
	int deleteObject(@Param("ids")Integer... ids);

	int getRowCount(@Param("name") String name);

	List<SysEmployee> findObject(
		      @Param("name")String  name,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);
 
}
