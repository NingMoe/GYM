package com.gy.pj.sys.dao.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.gy.pj.sys.dao.SysCoachGroupDao;
import com.gy.pj.sys.entity.SysCoachGroup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysCoachDaoTests {
	@Autowired
	private SysCoachGroupDao sysCoachDao;
	@Test
	public void testGetRowCount() {
		int row = sysCoachDao.deleteObjects(1);
		System.out.println(row);
	}
//	@Test
//	public void testFindPageObjects() {
//		List<SysCoachGroup> in = sysCoachDao.findPageObjects("A", 0, 3);
//		System.out.println(in.size());
//	}
	@Test
	public void testInsertPageObjects() {
		SysCoachGroup entity=new SysCoachGroup();
		entity.setClassNumber(3);
		entity.setCoachNumber(5);
		entity.setTecDirection("jj");
		int in = sysCoachDao.insertObject(entity);
		System.out.println(in);
	}
}
