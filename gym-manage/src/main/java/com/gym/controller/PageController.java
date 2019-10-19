package com.gym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "index";
	}

	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "gym_page";
	}

	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}

	@RequestMapping("{moduleUI}")
	public String doModuleUI(@PathVariable String moduleUI) {
		return moduleUI;
	}
}