package com.gy.pj.sys.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gym.dao.SysCmtDao;
import com.gym.entity.SysCmt;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SysCmtDaoTest {
	@Autowired
	private SysCmtDao dao;
	SysCmt entity=new SysCmt(5,"3000","1200");

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
		List<SysCmt> in = dao.findPageObjects("aaa",0,3);
		System.out.println(in);
	}
	
	@Test
	public void testDeleteObject() {
		int rows=dao.deleteObject(5);
		System.out.println(rows);
	}
	

}
