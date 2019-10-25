package com.gym.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;
import lombok.experimental.Accessors;
@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性,会忽略类中不存在的字段
@TableName("itemwarestate")
@Data
@Accessors(chain=true)
public class itemState extends BasePojo{
	private static final long serialVersionUID = 2393289744017807618L;
	@TableId(type=IdType.AUTO)
	private Long itemId;
	private Long itemNum;
	private Long minItemNum;
	private Long lockCapacity;
	private Long state;
	private String itemName;
	private String itemState;
	private String unit;
	private String note;
	private String specifications;
	private String saveWareLocation;
}
