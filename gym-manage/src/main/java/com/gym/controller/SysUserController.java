package com.gym.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.gym.entity.SysUser;
import com.gym.service.SysUserService;
import com.gym.vo.JsonResult;

@RequestMapping("/user/")
@Controller
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObjects(SysUser entity) {
		sysUserService.saveObject(entity);
		return new JsonResult("save ok");
	}

	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		sysUserService.deleteObject(id);
		return new JsonResult("delete ok");
	}

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		sysUserService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}

	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObjects(SysUser entity) {
		sysUserService.updateObject(entity);
		return new JsonResult("update ok");
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		PageInfo<SysUser> pageObject = sysUserService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}

	@RequestMapping("doFindObjectByUsername")
	@ResponseBody
	public JsonResult doFindObjectById(String username) {
		SysUser object = sysUserService.findObjectByUsername(username);
		return new JsonResult(object);
	}

	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id, Integer valid) {
		sysUserService.validById(id, valid, "admin");// "admin"用户将来是登陆用户
		return new JsonResult("update ok");
	}

	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username, String password) {
		// 1.获取Subject对象
		Subject subject = SecurityUtils.getSubject();
		// 2.通过Subject提交用户信息,交给shiro框架进行认证操作
		// 2.1对用户进行封装
		UsernamePasswordToken token = new UsernamePasswordToken(username, // 身份信息
				password);// 凭证信息
		// 2.2对用户信息进行身份认证
		subject.login(token);
		// 分析:
		// 1)token会传给shiro的SecurityManager
		// 2)SecurityManager将token传递给认证管理器
		// 3)认证管理器会将token传递给realm
		return new JsonResult("login ok");
	}
}
