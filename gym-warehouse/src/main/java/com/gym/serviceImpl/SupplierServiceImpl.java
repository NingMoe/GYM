package com.gym.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gym.exception.ServiceException;
import com.gym.mapper.SupplierMapper;
import com.gym.pojo.Supplier;
import com.gym.service.SupplierService;


@Service
public class SupplierServiceImpl implements SupplierService
{
	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public int insert(Supplier entity) {
		if (entity == null)
			throw new ServiceException("保存数据不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("角色名不能为空");
		int rows = supplierMapper.insert(entity);
		return rows;
	}

	@Override
	public int updateById(Supplier entity) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不能为空");
		int rows = supplierMapper.updateById(entity);
		return rows;
	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer selectCount() {
		System.out.println(supplierMapper.selectCount());
		return supplierMapper.selectCount();
	}

}
