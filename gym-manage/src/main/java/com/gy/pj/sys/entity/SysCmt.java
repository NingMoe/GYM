package com.gy.pj.sys.entity;

import lombok.Data;

@Data
public class SysCmt {
	private int id;
	private String username;
	private String cmt;
	public SysCmt(int id, String username, String cmt) {
		super();
		this.id = id;
		this.username = username;
		this.cmt = cmt;
	}
	public SysCmt() {
		super();
	}
	
}
