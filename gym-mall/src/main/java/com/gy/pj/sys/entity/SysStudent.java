package com.gy.pj.sys.entity;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysStudent implements Serializable{
	private static final long serialVersionUID = -641588349736025541L;
	private Integer id;
	private String name;
	private String gender;
	private Integer age;
	private double height;
	private double weight;
	private String phoneNumber;
	private String email;
	private String address;
	private Date creatTime;
	
}
