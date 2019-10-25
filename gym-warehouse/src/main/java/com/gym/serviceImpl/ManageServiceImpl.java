package com.gym.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gym.mapper.ManageMapper;
import com.gym.pojo.itemState;
import com.gym.service.ManageService;
import com.gym.thro.ServiceException;
@Service
public class ManageServiceImpl implements ManageService{
	@Autowired
	private ManageMapper manageMapper;
	@Override
	public PageInfo<itemState> findPageObjects(String name, Integer pageCurrent,Integer state) {
		// 1.验证参数合法性
				// 1.1验证pageCurrent的合法性，
				// 不合法抛出IllegalArgumentException异常
				if (pageCurrent == null || pageCurrent < 1)
					throw new IllegalArgumentException("当前页码不正确");
				// 2.基于条件查询总记录数
				// 2.1) 执行查询
				int rowCount=manageMapper.getRowCount(name);
				// 2.2) 验证查询结果，假如结果为0不再执行如下操作
				if (rowCount == 0) {
					
					throw new ServiceException("系统没有查到对应记录");
				}
				// 3.基于条件查询当前页记录(pageSize定义为2)
				// 3.1)定义pageSize
				//int pageSize = 2;
				// 3.2)计算startIndex
				//int startIndex = (pageCurrent - 1) * pageSize;
				// 3.3)执行当前数据的查询操作
				QueryWrapper<itemState> queryWrapper = new QueryWrapper<>();
				if (name!=null) {
					queryWrapper.eq("item_name", name);
				}
				if (state!=3) {
					queryWrapper.eq("state", state);
				}
				PageHelper.startPage(pageCurrent,2);
				List<itemState> records = manageMapper.selectList(queryWrapper);
				PageInfo<itemState> pageInfo=new PageInfo<itemState>(records);
				pageInfo.setPageNum(pageCurrent);
				// 4.对分页信息以及当前页记录进行封装
				// 4.1)构建PageObject对象
				//PageObject<SysCoach> pageObject = new PageObject<>();
				// 4.2)封装数据
				//pageObject.setPageCurrent(pageCurrent);
				//pageObject.setPageSize(pageSize);
				//pageObject.setRowCount(rowCount);
				//pageObject.setRecords(records);
				//pageObject.setPageCount((rowCount - 1) / pageSize + 1);
				// 5.返回封装结果。
				return pageInfo;
	}
}