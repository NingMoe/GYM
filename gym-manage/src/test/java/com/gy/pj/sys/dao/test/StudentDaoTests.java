package com.gy.pj.sys.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gym.dao.SysStudentDao;
import com.gym.entity.SysStudent;




@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTests {
	@Autowired
	private SysStudentDao gymStudentMapper;
	
	
	@Test
	public void deleteByPrimaryKey() {
		int deleteByPrimaryKey = gymStudentMapper.deleteByPrimaryKey(4);
		System.out.println(deleteByPrimaryKey);
	}
	
	@Test
	public void testInsert() {
		SysStudent gymStudent = new SysStudent(null,"小小","男",15,1.0,2.0,"11111","1111","111","1111");
		int insert = gymStudentMapper.insert(gymStudent);
		System.out.println(insert);
	}
	@Test
	public void testSelectAll() {
		List<SysStudent> selectAll = gymStudentMapper.selectAll();
		System.out.println(selectAll);
	}
	@Test
	public void testUpdateByPrimaryKey() {
		SysStudent gymStudent1 = new SysStudent(5,"小小","男",15,1.0,2.0,"11111","1111","111","1111");
		int updateByPrimaryKey = gymStudentMapper.updateByPrimaryKey(gymStudent1);
		System.out.println(updateByPrimaryKey);
	}
	
	@Test
	public void testSelectByPrimaryKey() {
		SysStudent selectByPrimaryKey = gymStudentMapper.selectByPrimaryKey(5);
		System.out.println(selectByPrimaryKey);
	}
}
