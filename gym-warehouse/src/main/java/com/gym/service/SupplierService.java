package com.gym.service;


import com.github.pagehelper.PageInfo;
import com.gym.pojo.Supplier;

public interface SupplierService {
	
	int insert(Supplier entity);
	
	int updateById(Supplier entity);

	Integer selectCount();

	PageInfo<Supplier> findPageObjects(String name, Integer pageCurrent);

	Supplier findObjectByName(String name);
}
