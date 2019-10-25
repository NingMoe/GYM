package com.gym.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gym.pojo.Supplier;

public interface SupplierMapper extends BaseMapper<Supplier>{
	
	/*
	 * int insert(@Param("entity") Supplier entity);
	 * 
	 * int updateById(@Param("entity") Supplier entity);
	 * 
	 * Integer selectCount(@Param("name") String name);
	 * 
	 * List<Supplier> selectList(Wrapper<Supplier> queryWrapper);
	 * 
	 * Integer selectCount(Wrapper<Supplier> queryWrapper);
	 */ 
		Supplier findObjectByName(String name);
	

	
}
