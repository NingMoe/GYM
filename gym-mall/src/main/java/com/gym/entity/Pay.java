package com.gym.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Pay implements Serializable{
	private static final long serialVersionUID = 
			337937965098657840L;
	private Long code;
	private String msg;
	private Long trade_no;
	private String out_trade_no;
	private String type;
	private Long pid;
	private String addtime;
	private String endtime;
	private String name;
	private Double money;
	private Long status;
	
	
}
