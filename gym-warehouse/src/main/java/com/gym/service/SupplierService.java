package com.gym.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gym.pojo.Supplier;

public interface SupplierService {
	
	int insert(Supplier entity);
	
	int updateById(Supplier entity);

	//List<Supplier> findAll();
	List<Supplier> findAll();
	
	Integer selectCount();
}
