package com.gym.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;
@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("item")
@Accessors(chain = true)
@Data
public class Item extends BasePojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795994121916981793L;
	private Long id;
	private String images;
	private String name;
	private String specifications;
	private String unit;
	private Integer price;
	private String branch;
	private String cate;
	private Integer state;
	private Integer minNum;
	private Integer lockState;
}
