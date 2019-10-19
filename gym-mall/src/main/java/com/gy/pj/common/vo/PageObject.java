package com.gy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class PageObject<T> implements Serializable {
	private static final long serialVersionUID = 4510785533464221167L;
	private Integer pageCurrent=1;
	private Integer pageSize=3;
	private Integer rowCount=0;
	private Integer pageCount=0;
	private List<T> records;
	public PageObject(Integer pageCurrent,  List<T> records, Integer rowCount,Integer pageSize) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;
		this.pageCount=(rowCount-1)/pageSize+1;
	}
	public PageObject() {
		super();
	}
}