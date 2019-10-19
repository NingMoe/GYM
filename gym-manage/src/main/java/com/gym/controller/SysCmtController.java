package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.entity.SysCmt;
import com.gym.service.SysCmtService;
import com.gym.vo.JsonResult;
import com.gym.vo.PageObject;

@RequestMapping("/cmt/")
@Controller
public class SysCmtController {
	@Autowired
	private SysCmtService sysCmtService;

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObjects(SysCmt entity) {
		sysCmtService.saveObject(entity);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysCmtService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doDeleteObjects")
	  @ResponseBody
	  public JsonResult doDeleteObjects(Integer... ids){
		sysCmtService.deleteObjects(ids);
		  return new JsonResult("delete ok");
	  }
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		PageObject<SysCmt> pageObject = sysCmtService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindObjectByUsername")
	@ResponseBody
	public JsonResult doFindObjectById(String username) {
		SysCmt object = sysCmtService.findObjectByUsername(username);
		return new JsonResult(object);
	}

	
}
