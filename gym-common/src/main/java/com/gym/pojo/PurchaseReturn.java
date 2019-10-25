package com.gym.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;
@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("purchase_return")
@Accessors(chain = true)
@Data
public class PurchaseReturn extends BasePojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2899108050545239111L;
	private Long returnId;
	private String supplierName;
	private String itemName;
	private String itemCate;
	private Integer itemNum;
	private Integer itemPrice;
	private String documentary;
	private String operator;
	private Integer state;
}
