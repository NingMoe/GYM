package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.common.vo.JsonResult;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysCoachGroup;
import com.gym.service.SysCoachGroupService;

@RequestMapping("/CoachGroup/")
@Controller
public class SysCoachGroupController {
	@Autowired
	private SysCoachGroupService sysCoachGroupService;

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String tecDirection, Integer pageCurrent) {
		PageObject<SysCoachGroup> PageObject = sysCoachGroupService.findPageObjects(tecDirection, pageCurrent);
		return new JsonResult(PageObject);
	}
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		sysCoachGroupService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysCoachGroup entity) {
		sysCoachGroupService.saveObject(entity);
		return new JsonResult("save ok");
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer groupId) {
		return new JsonResult(sysCoachGroupService.findById(groupId));
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysCoachGroup entity) {
		sysCoachGroupService.updateObject(entity);
		return new JsonResult("update ok");
	}
}
