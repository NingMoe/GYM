package com.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.gym.entity.SysFood;
import com.gym.service.SysFoodService;
import com.gym.vo.JsonResult;
import com.gym.vo.Node;




@RequestMapping("/food/")
@RestController
public class SysFoodController {
	@Autowired
	private SysFoodService sysFoodService;
	
	@GetMapping("doFindFoodObjects")
	public JsonResult doFindPageObjects(
			String food,
			Integer pageCurrent) {
		PageInfo<SysFood> findFoodObjects = sysFoodService.findFoodObjects(food, pageCurrent);
		return new JsonResult(findFoodObjects);}
	
	
	@RequestMapping("doDeleteByIds")
	public JsonResult doDeleteByIds(Integer... ids) {
		sysFoodService.deleteByIds(ids);
		return new JsonResult("delete ok");
	}
	@RequestMapping("doSaveObjects")
	public JsonResult doSaveObjects(SysFood entity) {
		sysFoodService.insertObject(entity);
		return new JsonResult("save ok");
	}
	
	@RequestMapping("doUpdateObjects")
	public JsonResult doUpdateObjects(SysFood entity) {
		sysFoodService.updataObject(entity);
		return new JsonResult("update ok");
	}
	
	@RequestMapping("doFindFoods")
	public JsonResult doFindFoods( ) {
		List<Node> findFoodAndList = sysFoodService.findFoodAndList();
		return new JsonResult(findFoodAndList);
	}
	
	@RequestMapping("doFindAll")
	public JsonResult doFindAll( ) {
		List<SysFood> findAll = sysFoodService.findAll();
		return new JsonResult(findAll);
	}
}
