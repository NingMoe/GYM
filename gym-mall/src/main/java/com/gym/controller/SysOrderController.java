package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.common.vo.JsonResult;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysOrder;
import com.gym.service.SysOrderService;

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
