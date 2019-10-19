package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.common.vo.JsonResult;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysEquipment;
import com.gym.service.SysEquipmentService;

@RequestMapping("/equipment/")
@Controller
public class SysEquipmentController {
	@Autowired
	private SysEquipmentService sysEquipmentService;

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageObject<SysEquipment> pageObject = sysEquipmentService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindObjectByName")
	@ResponseBody
	public JsonResult doFindObjectById(String name) {
		SysEquipment object = sysEquipmentService.findObjectByName(name);
		return new JsonResult(object);
	}

	
}
