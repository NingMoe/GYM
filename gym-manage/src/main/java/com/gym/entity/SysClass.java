package com.gym.entity;

import lombok.Data;

//特色课程
@Data
public class SysClass {
	private int id;
	private String name;
	private String picUrl;
	private String description;
	private int coachId;
	private double price;
	private int number;
	
	public SysClass(int id, String name, String picUrl, String description, int coachId, double price, int number) {
		super();
		this.id = id;
		this.name = name;
		this.picUrl = picUrl;
		this.description = description;
		this.coachId = coachId;
		this.price = price;
		this.number = number;
	}

	public SysClass() {
		super();
	}
	
	
}
