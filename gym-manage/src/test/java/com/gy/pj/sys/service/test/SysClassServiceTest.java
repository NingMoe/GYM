package com.gy.pj.sys.service.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysClass;
import com.gy.pj.sys.service.SysClassService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysClassServiceTest {
	@Autowired
	private SysClassService sv;
	
	SysClass entity=new SysClass(5, "A", "aaa", "aaaaaaaa", 21, 5000, 50);
	SysClass entity2=new SysClass(6, "A", "aaa", "aaaaaaaa", 21, 5000, 50);
	
	@Test
	public void testSaveObject() {
		int rows=sv.saveObject(entity2);
		System.out.println(rows);
	}
	@Test
	public void tesDeleteObject() {
		int rows=sv.deleteObject(6);
		System.out.println(rows);
	}
	@Test
	public void testfindObjectByName() {
		SysClass c=sv.findObjectByName("A");
		System.out.println(c);
	}
	@Test
	public void testUpdateObject() {
		int rows=sv.updateObject(entity2);
		System.out.println(rows);
	}
	@Test
	public void testFindPageObjects() {
		PageObject<SysClass> obj=sv.findPageObjects("A", 1);
		System.out.println(obj);
	}
}
