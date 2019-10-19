package com.gy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.gy.pj.common.vo.JsonResult;
import com.gy.pj.sys.entity.SysAccount;
import com.gy.pj.sys.service.SysAccountService;

@RequestMapping("/Account/")
@Controller
public class SysAccountController {
	@Autowired
	private SysAccountService sysAccountService;
	
	//111
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageInfo<SysAccount> pageObject = sysAccountService.findPageObjects(name,pageCurrent);
		return new JsonResult(pageObject);
	}

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		sysAccountService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysAccount entity) {
		sysAccountService.saveObject(entity);
   	 return new JsonResult("save ok");
    }
	
	@RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysAccount entity) {
		sysAccountService.updateObject(entity);
   	 return new JsonResult("update ok");
    }
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		return new JsonResult(sysAccountService.findById(id));
	}
}
