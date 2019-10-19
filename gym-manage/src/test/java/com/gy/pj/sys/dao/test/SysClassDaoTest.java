package com.gy.pj.sys.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gym.dao.SysClassDao;
import com.gym.entity.SysClass;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SysClassDaoTest {
	@Autowired
	private SysClassDao dao;
	SysClass entity=new SysClass(5,"零22","cccc","zxc",23,3000,1200);

	@Test
	public void testInsert() {
		int rows=dao.insertObject(entity);
		System.out.println(rows);
	}
	@Test
	public void testGetRowCount() {
		int row = dao.getRowCount("零");
		System.out.println(row);
	}
	@Test
	public void testFindPageObjects() {
		List<SysClass> in = dao.findPageObjects("零",0,3);
		System.out.println(in);
	}
	
	@Test
	public void testDeleteObject() {
		int rows=dao.deleteObject(5);
		System.out.println(rows);
	}
	
	@Test
	public void testUpdateObject() {
		System.out.println(entity);
		int rows=dao.updateObject(entity);
		System.out.println(entity);
		System.out.println(rows);
		
	}

}
