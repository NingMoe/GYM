package com.gy.pj.sys.service.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gy.pj.common.vo.PageObject;

import com.gy.pj.sys.entity.SysCmt;

import com.gy.pj.sys.service.SysCmtService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysCmtServiceTest2 {
	@Autowired
	private SysCmtService sv;
	
	SysCmt entity=new SysCmt(12, "A", "aaa");
	SysCmt entity2=new SysCmt(13, "A", "aaa");
	
	@Test
	public void testSaveObject() {
		int rows=sv.saveObject(entity2);
		System.out.println(rows);
	}
	@Test
	public void tesDeleteObject() {
		int rows=sv.deleteObject(13);
		System.out.println(rows);
	}
	@Test
	public void testfindObjectByUsername() {
		SysCmt c=sv.findObjectByUsername("aaa");
		System.out.println(c);
	}
	@Test
	public void testFindPageObjects() {
		PageObject<SysCmt> obj=sv.findPageObjects("aaa", 1);
		System.out.println(obj);
	}
}
