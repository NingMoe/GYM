package com.gy.pj.sys.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysCoach implements Serializable {
	private static final long serialVersionUID = -3286833965294107278L;
	private String name;
	private String gender;
	private String tecDirection;
	private Integer id;
	private Integer groupId;
	private Integer stuNumber;
	private Integer tecNumber;
	private String avatar;

	public SysCoach(String name, String gender, String tecDirection, Integer id, Integer groupId, Integer stuNumber,
			Integer tecNumber,String avatar) {
		super();
		this.name = name;
		this.gender = gender;
		this.tecDirection = tecDirection;
		this.id = id;
		this.groupId = groupId;
		this.stuNumber = stuNumber;
		this.tecNumber = tecNumber;
		this.avatar= avatar;
	}

	public SysCoach() {
		super();
	}

}
