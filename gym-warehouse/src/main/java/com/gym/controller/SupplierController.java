package com.gym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.gym.pojo.Supplier;
import com.gym.service.SupplierService;
import com.gym.vo.JsonResult;

@RequestMapping("/supplier/")
@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageInfo<Supplier> pageObject = supplierService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindObjectByName")
	@ResponseBody
	public JsonResult doFindObjectById(String name) {
		Supplier object = supplierService.findObjectByName(name);
		return new JsonResult(object);
	}
	
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(Supplier entity) {
		int rows = supplierService.insert(entity);
		return new JsonResult("save ok");
	}
	
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(Supplier entity) {
		System.out.println("update...");
		int rows = supplierService.updateById(entity);
		return new JsonResult("update ok");
	}
	
	

}
