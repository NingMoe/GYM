package com.gym.entity;

import java.io.Serializable;

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
	
	public SysFood(Integer id, String food, double heat, double protein, double carbo, double axunge, double chol,
			double vitamin, String scope) {
		super();
		this.id = id;
		this.food = food;
		this.heat = heat;
		this.protein = protein;
		this.carbo = carbo;
		this.axunge = axunge;
		this.chol = chol;
		this.vitamin = vitamin;
		this.scope = scope;
	
	}

}
