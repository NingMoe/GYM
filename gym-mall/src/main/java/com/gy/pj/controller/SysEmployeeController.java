package com.gy.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gy.pj.common.vo.JsonResult;
import com.gy.pj.common.vo.PageObject;
import com.gy.pj.sys.entity.SysEmployee;
import com.gy.pj.sys.service.SysEmployeeService;

@RequestMapping("/Employee/")
@Controller
public class SysEmployeeController {
	@Autowired
	private SysEmployeeService sysEmployeeService;
	
	@RequestMapping("doDeleteObject")
	  @ResponseBody
	  public JsonResult doDeleteObject(Integer... ids){
		  sysEmployeeService.deleteObject(ids);
		  return new JsonResult("delete ok");
	  }
	@RequestMapping("doFindObject")
	  @ResponseBody
	public JsonResult doFindObject(String name,
	      Integer pageCurrent){
		PageObject<SysEmployee>  pageObject=
				 sysEmployeeService.findObject(name,pageCurrent);
				return new JsonResult(pageObject);
		    	                         
		      }
}
