package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.common.vo.JsonResult;
import com.gym.common.vo.PageObject;
import com.gym.entity.SysCoach;
import com.gym.service.SysCoachService;


@RequestMapping("/Coach/")
@Controller
public class SysCoachController {
	@Autowired
	private SysCoachService sysCoachService;

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		PageObject<SysCoach> pageObject = sysCoachService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}

}
