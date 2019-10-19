package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gym.common.vo.JsonResult;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysStudent;
import com.gym.service.SysStudentService;

@RequestMapping("/Student/")
@Controller
public class SysStudentController {

	@Autowired
	private SysStudentService sysStudentService;

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		PageObject<SysStudent> pageObject = sysStudentService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObject);
	}

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		sysStudentService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}
	
	@RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysStudent entity) {
   	 sysStudentService.saveObject(entity);
   	 return new JsonResult("save ok");
    }
	
	@RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysStudent entity) {
		sysStudentService.updateObject(entity);
   	 return new JsonResult("update ok");
    }
    
}
