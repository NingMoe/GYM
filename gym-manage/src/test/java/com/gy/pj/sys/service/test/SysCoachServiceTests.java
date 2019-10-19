package com.gy.pj.sys.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gym.entity.SysCoach;
import com.gym.entity.SysCoachGroup;
import com.gym.service.SysCoachService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysCoachServiceTests {
	@Autowired
	private SysCoachService sysCoachService;
	@Test
	public void testFindPageObjects() {
		SysCoach entity=new SysCoach();
		entity.setGroupId(1);
		entity.setGender("男");
		entity.setId(16);
		entity.setTecDirection("j");
		entity.setStuNumber(15);
		SysCoachGroup c = new SysCoachGroup();
		c.setGroupId(5);
		c.setClassNumber(5);
		c.setCoachNumber(6);
		c.setTecDirection("aa");
		SysCoach in = sysCoachService.findById(16);
		System.out.println(in);
	}
}
