package com.gym.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.pojo.Supplier;
import com.gym.service.SupplierService;
import com.gym.vo.LayUITable;

@RequestMapping("/supplier/")
@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("query")
	@ResponseBody
	public LayUITable findAll() {
		LayUITable table = new LayUITable();
		//table.setCode(code);
		List<Supplier> data = new ArrayList<Supplier>();
		table.setCode(0);
		table.setMsg("");
		data = supplierService.findAll();
		table.setCount(supplierService.selectCount());
		table.setData(data);
		return table;
	}
}
