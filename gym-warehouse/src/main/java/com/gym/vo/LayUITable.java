package com.gym.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class LayUITable {
//	  "code": res.status, //解析接口状态
//      "msg": res.message, //解析提示文本
//      "count": res.total, //解析数据长度
//      "data": res.data.item //解析数据列表
	private Integer code;
	private String msg;
	private Integer count;
	private List<?> data;
}
