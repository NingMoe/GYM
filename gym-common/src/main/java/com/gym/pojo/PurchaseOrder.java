package com.gym.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.experimental.Accessors;
@JsonIgnoreProperties(ignoreUnknown=true) //表示JSON转化时忽略未知属性
@TableName("purchase_order")
@Accessors(chain = true)
@Data
public class PurchaseOrder  extends BasePojo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6599089995418760893L;
	private Long orderId;
	private String supplierName;
	private String itemName;
	private String itemCate;
	private Integer itemNum;
	private Integer itemPrice;
	private String documentary;
	private String purchaser;
	private Integer orderState;
	private String notes;
}
