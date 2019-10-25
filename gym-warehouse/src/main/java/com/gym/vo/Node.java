package com.gym.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Node implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String food;
	private double heat;
	private double carbo;
}
