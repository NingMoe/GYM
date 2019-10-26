package com.gym.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.jute.compiler.JInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
			throw new ServiceException("供应商名称不能为空");
		Date a = new Date();
		entity.setCreated(a);
		entity.setUpdated(a);
		int rows = supplierMapper.insert(entity);
		System.out.println(entity);
		return rows;
	}

	@Override
	public int updateById(Supplier entity) {
		//1.合法性验证
		if(entity==null)
			throw new ServiceException("更新的对象不能为空");

		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("不能为空");

		//2.更新数据
		entity.setCreated(entity.getCreated());
		entity.setUpdated(new Date());
		int rows=supplierMapper.updateById(entity);
		if(rows==0)
			throw new ServiceException("对象可能已经不存在");

		//3.返回结果
		return rows;
	}

	@Override
	public PageInfo<Supplier> findPageObjects(String name, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("当前页码不正确");
		QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
		if(name!=null) {
			queryWrapper.eq("name", name); //前者为字段名  后者为变量名
		}
		int rowCount = supplierMapper.selectCount(queryWrapper);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		//int pageSize = 3;
		//int startIndex = (pageCurrent - 1) * pageSize;
		if (name!=null) {
			queryWrapper.eq("name", name);
		}
		PageHelper.startPage(pageCurrent,3);
		List<Supplier> records = supplierMapper.selectList(queryWrapper);
		PageInfo<Supplier> pageInfo = new PageInfo<Supplier>(records);
		pageInfo.setPageNum(pageCurrent);
		return pageInfo;
	}

	@Override
	public Supplier findObjectByName(String name) {
		//1.合法性验证
				if(name==null)
					throw new ServiceException("name的值不合法");
				//2.执行查询
				Supplier result=supplierMapper.findObjectByName(name);
				//3.验证结果并返回
				if(result==null)
					throw new ServiceException("此记录已经不存在");
				return result;
	}

	@Override
	public Integer selectCount() {
		QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
	//	queryWrapper.eq("name",name);
		int rows = supplierMapper.selectCount(queryWrapper);
		return null;
	}

	@Override
	public Supplier findObjectById(Integer id) {
		//1.合法性验证
		if(id==null)
			throw new ServiceException("id的值不合法");
		//2.执行查询
		Supplier result=supplierMapper.selectById(id);
		//3.验证结果并返回
		if(result==null)
			throw new ServiceException("此记录已经不存在");
		return result;
	}

}
