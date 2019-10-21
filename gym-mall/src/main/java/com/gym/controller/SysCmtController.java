package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.common.vo.JsonResult;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysUser;
import com.gym.service.SysUserService;

@RequestMapping("/user/")
@Controller
public class SysCmtController {
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObjects(SysUser entity) {
		sysUserService.saveObject(entity);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysUserService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doDeleteObjects")
	  @ResponseBody
	  public JsonResult doDeleteObjects(Integer... ids){
		sysUserService.deleteObjects(ids);
		  return new JsonResult("delete ok");
	  }
	
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObjects(SysUser entity){
		sysUserService.updateObject(entity);
		return new JsonResult("update ok");
	}
	
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		PageObject<SysUser> pageObject = sysUserService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindObjectByUsername")
	@ResponseBody
	public JsonResult doFindObjectById(String username) {
		SysUser object = sysUserService.findObjectByUsername(username);
		return new JsonResult(object);
	}

	
}
