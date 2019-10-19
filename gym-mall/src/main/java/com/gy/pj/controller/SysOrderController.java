package com.gy.pj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gy.pj.common.vo.JsonResult;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysOrder;
import com.gy.pj.sys.service.SysOrderService;

@RequestMapping("/order/")
@Controller
public class SysOrderController {
	@Autowired
	private SysOrderService sysOrderService;
	
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObjects(SysOrder entity) {
		sysOrderService.saveObject(entity);
		System.out.println(entity);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageObject<SysOrder> pageObject = sysOrderService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindObjectByName")
	@ResponseBody
	public JsonResult doFindObjectById(String userName) {
		System.out.println("hellollllllllll");
		List<SysOrder> object = sysOrderService.findObjectByClassname(userName);
		return new JsonResult(object);
	}

	
}
