package com.gym.ex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.ex.service.ExService;
import com.gym.pojo.ExPojo;
import com.gym.vo.LayUITable;

@RestController
@RequestMapping("/ex/")
public class ExController {
	@Autowired
	private ExService exService;
	@RequestMapping("query")
	public LayUITable doShwoLayUITable(Integer page,Integer limit) {
		return exService.showAllEx(page,limit);
	}
}
