package com.gym.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;
@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("supplier")
@Accessors(chain = true)
@Data
public class Supplier {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6081681527970246831L;
	private Long id;
	private String name;
	private String addr;
	private String contact;
	private String phone;
	private String cate;
	private String notes;
}
