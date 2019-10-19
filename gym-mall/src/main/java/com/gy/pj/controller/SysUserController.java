package com.gy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gy.pj.common.vo.JsonResult;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysCmt;
import com.gy.pj.sys.service.SysCmtService;

@RequestMapping("/cmt/")
@Controller
public class SysUserController {
	@Autowired
	private SysCmtService sysCmtService;
	
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
