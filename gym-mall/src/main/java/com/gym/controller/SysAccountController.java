package com.gym.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gym.common.vo.JsonResult;
import com.gym.entity.SysAccount;
import com.gym.service.SysAccountService;

@RequestMapping("/Account/")
@Controller
public class SysAccountController {
	@Autowired
	private SysAccountService sysAccountService;

	@RequestMapping("doRegister")
    public JsonResult doSaveObject(SysAccount entity) {
		sysAccountService.saveObject(entity);
   	 return new JsonResult("Register ok");
    }
	
	@RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysAccount entity) {
		sysAccountService.updateObject(entity);
   	 return new JsonResult("update ok");
    }
	
	/*
	 * @RequestMapping("doLogin") public JsonResult doLogin(String account,String
	 * pass) { sysAccountService.login(account, pass); return new
	 * JsonResult("Login ok"); }
	 */
	@RequestMapping(value = "doLogin", method = {RequestMethod.POST, RequestMethod.GET})
    public String login() {
		System.out.println("login...");
        return "HomePage";
    }

    @RequestMapping(value = "/loginPage", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public JsonResult login(HttpServletRequest request, HttpSession session) {
        String account = request.getParameter("account");
        String pass = request.getParameter("pass");
        System.out.println("你输入的用户名为：" + account);
        System.out.println("你输入的密码为：" + pass);
        sysAccountService.login(account, pass);
        session.setAttribute("account", account);
        return new JsonResult(account);
    }
    @RequestMapping(value = "/registerPage", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public int register(HttpServletRequest request, HttpSession session) {
    	System.out.println("lo...");
    	String account = request.getParameter("account");
    	String pass = request.getParameter("pass");
    	SysAccount entity=new SysAccount(null, account, pass, null, null, null);
    	System.out.println("你输入的用户名为：" + account);
    	System.out.println("你输入的密码为：" + pass);
    	int rows = sysAccountService.saveObject(entity);
    	session.setAttribute("account", account);
    	return rows;
    }

    @RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
    public String loginindex() {
        return "/login/test";

    }
}
