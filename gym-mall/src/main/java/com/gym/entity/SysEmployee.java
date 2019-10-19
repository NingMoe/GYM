package com.gym.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;
@Accessors(chain = true)
@Data
public class SysEmployee implements Serializable {

	private static final long serialVersionUID = -1975719386166252589L;
	private Integer id;
	 private String name;
	 private String gender;
	 private  Integer  age;
	 private String idNumber;
	 private String eduBackground;
	 private String department;
	 private String position;
	 private Integer salary;
	 private Date hiredate;
}
