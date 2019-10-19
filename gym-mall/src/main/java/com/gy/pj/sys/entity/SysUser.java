package com.gy.pj.sys.entity;

import lombok.Data;

@Data
public class SysUser {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String icon;
	private String email;
	private String intro;
	public SysUser(int id, String username, String password, String sex, String icon, String email,
			String intro) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.icon = icon;
		this.email = email;
		this.intro = intro;
	}
	public SysUser() {
		super();
	}
	
	
}
