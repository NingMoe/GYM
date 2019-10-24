package com.jt;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gym.mapper.SupplierMapper;
import com.gym.pojo.Supplier;
import com.gym.service.SupplierService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSupplier {
	@Autowired
	private SupplierMapper mapper;
	@Autowired
	private SupplierService service;
	
	@Test
	public void testInsert() {
		Supplier entity = new Supplier();
		entity.setAddr("xxx")
				.setCate("food")
				.setContact("xm")
				.setCreated(new Date())
				.setUpdated(new Date());
		entity.setId(5L)
				.setName("keji")
				.setNotes("none")
				.setPhone("130xxxxx");
		int rows = mapper.insert(entity);
		System.out.println(rows);
	}
}
