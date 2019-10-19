package com.gym.entity;

import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;
@Accessors(chain = true)
@Data
public class SysEmployee implements Serializable {

	private static final long serialVersionUID = -1975719386166252589L;
	private Integer Id;
	private String name;
	private String gender;
	private  Integer  age;
	private String idNumber;
	private String eduBackground;
	private String department;
	private String position;
	private Integer salary;
	private String hiredate;
	private String avatar;
//	private String uploadDir;
	public SysEmployee(Integer id, String name, String gender, Integer age, String idNumber, String eduBackground,
			String department, String position, Integer salary, String hiredate,String avatar) {
		super();
		Id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.idNumber = idNumber;
		this.eduBackground = eduBackground;
		this.department = department;
		this.position = position;
		this.salary = salary;
		this.hiredate = hiredate;
		this.avatar = avatar;
//		this.uploadDir=uploadDir;
	}

}
