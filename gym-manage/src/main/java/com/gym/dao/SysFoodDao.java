package com.gym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gym.entity.SysFood;
import com.gym.vo.Node;

@Mapper
public interface SysFoodDao {
	int getRowCount(@Param("food")String food);
	List<SysFood> findObject(@Param("food")String food);
	@Select("select * from gym_foods")
	List<SysFood> findALl();
	int deleteObjects(@Param("ids")Integer...ids);
	int insertObjects(SysFood entity);
	int updataObjects(SysFood entity);
	List<Node> findfoodsAndHeat();
}
