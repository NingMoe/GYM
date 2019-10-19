package com.gy.pj.sys.entity;
import java.io.Serializable;
import lombok.Data;
@Data
public class SysAccount implements Serializable{
	private static final long serialVersionUID = -8461922911686176279L;
	private Integer id;
	private String account;
	private String pass;
	private String name;
	private String phoneNumber;
	private String email;
	public SysAccount(Integer id, String account, String pass, String name, String phoneNumber, String email) {
		super();
		this.id = id;
		this.account = account;
		this.pass = pass;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	
	
}
