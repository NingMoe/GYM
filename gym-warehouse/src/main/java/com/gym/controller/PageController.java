package com.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "index";
	}
	
	@RequestMapping("do")
	public String doLoginUI() {
		return "member-list2";
	}

	@RequestMapping("{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
		return moduleUI;
	}
}