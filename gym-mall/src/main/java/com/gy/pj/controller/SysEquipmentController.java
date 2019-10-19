package com.gy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gy.pj.common.vo.JsonResult;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysEquipment;
import com.gy.pj.sys.service.SysEquipmentService;

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
