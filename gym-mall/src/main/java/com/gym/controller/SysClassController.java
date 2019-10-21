package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.common.vo.JsonResult;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysClass;
import com.gym.service.SysClassService;

@RequestMapping("/class/")
@Controller
public class SysClassController {
	@Autowired
	private SysClassService sysClassService;

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageObject<SysClass> pageObject = sysClassService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindObjectByName")
	@ResponseBody
	public JsonResult doFindObjectById(String name) {
		SysClass object = sysClassService.findObjectByName(name);
		return new JsonResult(object);
	}

	
}
