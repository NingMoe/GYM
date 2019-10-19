package com.gy.pj.sys.controller;

import javax.servlet.http.HttpSession;




/**
 * 所用控制器类的父类
 */
public abstract class BaseController {
	
	protected static final String SESSION_UID="uid";
	protected static final String SESSION_USERNAME="username";
	
	protected static final Integer SUCCESS=20;
	// 静态常量的命名：所有字母都大写，单词用_隔开，尽量说明白，不要嫌长
	protected static final Integer ERROR_USERNAME_DUPLICATE=30;
	/**
	 * 对控制器中的异常进行统一处理
	 * @param e 异常对象
	 * @return JsonResult封装响应信息
	 */
	public String getUsernameFromSession(HttpSession session) {
		// 从session中获取username
		return session.getAttribute(SESSION_USERNAME).toString();
	}
	
	public Integer getUidFromSession(HttpSession session) {
		// 从session中获取uid
		return Integer.valueOf(session.getAttribute(SESSION_UID).toString());
	}
	
	
	

}




