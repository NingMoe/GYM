package com.gy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.gy.pj.sys.entity.SysFood;

@Mapper
public interface SysFoodDao {
	 int getRowCount(@Param("food")String food);
	 
	List<SysFood> findFoodObject(
		      @Param("food")String food,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);
}
