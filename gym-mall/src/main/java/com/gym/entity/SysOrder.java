package com.gym.entity;

import lombok.Data;

@Data
public class SysOrder {
	private int id;
	private String orderId;
	private String className;
	private String userName;
	private String phoneNumber;
	private double price;
	private String orderTime;
	private String payTime;
	private String payType;
	private String payState;
	public SysOrder() {
		super();
	}

	public SysOrder(int id, String orderId, String className, String userName, String phoneNumber, double price,
			String orderTime, String payTime, String payType, String payState) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.className = className;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.price = price;
		this.orderTime = orderTime;
		this.payTime = payTime;
		this.payType = payType;
		this.payState = payState;
	}
	
	
	
}
