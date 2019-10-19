package com.gym.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysEquipment implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String ename;
	private int quantity;
	private String price;
	private String type;
	private String requir;
	private String part;
	private String hard;
	public SysEquipment(Integer id, String ename, int quantity, String price, String type, String requir, String part,
			String hard) {
		super();
		this.id = id;
		this.ename = ename;
		this.quantity = quantity;
		this.price = price;
		this.type = type;
		this.requir = requir;
		this.part = part;
		this.hard = hard;
	}
	
	
}
