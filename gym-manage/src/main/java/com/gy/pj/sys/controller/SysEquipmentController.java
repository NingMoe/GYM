package com.gy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.gy.pj.common.vo.JsonResult;
import com.gy.pj.sys.entity.SysEquipment;
import com.gy.pj.sys.service.SysEquipmentService;

@RestController
@RequestMapping("/equipment/")
public class SysEquipmentController {
	@Autowired SysEquipmentService sysEquipmentService;
	@GetMapping("doFindEquipmentObjects")
	public JsonResult doFindPageObjects(
			String ename,
			Integer pageCurrent) {
		PageInfo<SysEquipment> findEquipmentObjects = sysEquipmentService.findEquipmentObjects(ename, pageCurrent);
		return new JsonResult(findEquipmentObjects);}
	
	@RequestMapping("doDeleteByIds")
	public JsonResult doDeleteByIds(Integer... ids) {
		sysEquipmentService.deleteByIds(ids);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doSaveObjects")
	public JsonResult doSaveObjects(SysEquipment entity) {
		sysEquipmentService.insertObject(entity);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doUpdateObjects")
	public JsonResult doUpdateObjects(SysEquipment entity) {
		sysEquipmentService.insertObject(entity);
		return new JsonResult("update ok");
	}
	

}
