package com.gy.pj.sys.dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gym.dao.SysEmployeeDao;
import com.gym.entity.SysEmployee;;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysEmployeeDaoTests {
	@Autowired
	private SysEmployeeDao sysEmployeeDao;
	@Test
	public void testGetRowCount() {
		List<SysEmployee> row = sysEmployeeDao.findAllObject();
		System.out.println(row);
	}
	@Test
	public void testFindObject() {
		SysEmployee entity = new SysEmployee(5, null, null, null, null, null, null, null, null, null, null);
		
			sysEmployeeDao.updateObject(entity);
		System.out.println(entity);
	}
}
