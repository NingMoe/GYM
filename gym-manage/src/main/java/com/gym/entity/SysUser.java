package com.gym.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysUser implements Serializable {
	private static final long serialVersionUID = 4670623240138401065L;
	private Integer id;
	private String username;
	private String password;// md5
	private String salt;
	private String email;
	private String mobile;
	private Integer valid = 1;
	private String deptId; // private Integer deptId;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;

	public SysUser() {
		super();
	}

	public SysUser(Integer id, String username, String password, String salt, String email, String mobile,
			Integer valid, String deptId, Date createdTime, Date modifiedTime, String createdUser,
			String modifiedUser) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.email = email;
		this.mobile = mobile;
		this.valid = valid;
		this.deptId = deptId;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.createdUser = createdUser;
		this.modifiedUser = modifiedUser;
	}

}
