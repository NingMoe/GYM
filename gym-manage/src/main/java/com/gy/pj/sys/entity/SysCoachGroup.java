package com.gy.pj.sys.entity;

import java.io.Serializable;


import lombok.Data;
@Data
public class SysCoachGroup implements Serializable{
	private static final long serialVersionUID = -3651405380562956565L;
	private Integer groupId;
	private Integer coachNumber;
	private Integer classNumber;
	private String tecDirection;
	public SysCoachGroup(Integer groupId, Integer coachNumber, Integer classNumber, String tecDirection) {
		super();
		this.groupId = groupId;
		this.coachNumber = coachNumber;
		this.classNumber = classNumber;
		this.tecDirection = tecDirection;
	}
	public SysCoachGroup() {
		// TODO Auto-generated constructor stub
	}
}