package com.gy.pj.sys.service.test;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gym.entity.SysEmployee;
import com.gym.service.SysEmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysEmployeeServiceTests {
	@Autowired
	private SysEmployeeService sysEmployeeService;
	@Test
	public void testFindObject() {
		List<SysEmployee> in = sysEmployeeService.findAllObject();
		System.out.println(in);
	}
}
