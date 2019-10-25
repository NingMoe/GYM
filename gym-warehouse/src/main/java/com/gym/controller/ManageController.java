package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.gym.pojo.itemState;
import com.gym.service.ManageService;
import com.gym.vo.SysResult;


@RequestMapping("/manage")
@Controller
public class ManageController {
	@Autowired
	private ManageService manageService;

	@RequestMapping("/itemStatu")
	@ResponseBody
	public SysResult doFindPageObjects(String name, Integer pageCurrent,Integer state) {
		PageInfo<itemState> pageObject = manageService.findPageObjects(name, pageCurrent,state);
		return SysResult.success(pageObject);
	}
}
