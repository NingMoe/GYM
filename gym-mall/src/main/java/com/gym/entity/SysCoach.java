package com.gym.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysCoach implements Serializable{
	private static final long serialVersionUID = -3286833965294107278L;
	private Integer id;
	private String name;
	private String tecDirection;
}
