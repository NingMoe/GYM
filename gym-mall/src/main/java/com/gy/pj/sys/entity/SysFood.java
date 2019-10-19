package com.gy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysFood implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String food;
	private double heat;
	private double protein;
	private double carbo;
	private double axunge;
	private double chol;
	private double vitamin;
	private String scope;
	private Date createdTime;

}
