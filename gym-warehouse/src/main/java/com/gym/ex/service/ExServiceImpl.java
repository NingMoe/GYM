package com.gym.ex.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.javassist.Loader.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.ex.mapper.ExMapper;
import com.gym.pojo.ExPojo;
import com.gym.vo.LayUITable;

@Service
public class ExServiceImpl implements ExService{
	@Autowired
	private ExMapper exMapper;

	

	@Override
	public LayUITable showAllEx(Integer page, Integer rows) {
		//1.获取商品的记录总数
		int total = exMapper.selectCount(null);
		int start = (page - 1) * rows;
		List<ExPojo> itemList = 
		exMapper.findItemByPage(start,rows);
	
		return new LayUITable(0, "", total, itemList);
	}

}
