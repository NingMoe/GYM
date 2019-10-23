package com.gym.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;

@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("ex_warehouse")
@Data
@Accessors(chain=true)
public class ExPojo extends BasePojo{
//
//	`ex_id` VARCHAR (150) COMMENT '出库单号',
//	`ex_date` DATETIME COMMENT '出库日期',
//	`ex_item` VARCHAR (60) COMMENT '商品名称',
//	`ex_num` VARCHAR (90) COMMENT '商品数量',
//	`ex_unit` VARCHAR (30) COMMENT '商品单位',
//	`ex_model` VARCHAR (30) COMMENT '商品规格型号',
//	`ex_status` INT (10) COMMENT '状态',
//	`order_id` VARCHAR (150) COMMENT '订单id',
//	`warehouse` VARCHAR (30) COMMENT '仓库名称',
	@TableId(type = IdType.AUTO)
	private String exId;
	private Date exDate;
	private String exItem;
	private Integer exNum;
	private String exUnit;
	private String exModel;
	private Integer exStatus;
	private String orderId;
	private String warehouse;
	
	
}
