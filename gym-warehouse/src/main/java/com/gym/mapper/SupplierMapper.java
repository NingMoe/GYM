package com.gym.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gym.pojo.Supplier;

@Mapper
public interface SupplierMapper extends BaseMapper<Supplier>{
	
	int insert(@Param("entity") Supplier entity);
	
	int updateById(@Param("entity") Supplier entity);

	//List<Supplier> findAll();
	List<Object> selectObjs(@Param("queryWrapper") Wrapper<Supplier> queryWrapper);
	
	Integer selectCount();
}
