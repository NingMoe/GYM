package com.gy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class JsonResult implements Serializable {
	private static final long serialVersionUID = 8814124655949996003L;
	private int state = 1;
	private String message = "ok";
	private Object data;

	public JsonResult() {
	}

	public JsonResult(Throwable t) {
		this.state = 0;
		this.message = t.getMessage();
	}

	public JsonResult(String message) {
		super();
		this.message = message;
	}

	public JsonResult(Object data) {
		super();
		this.data = data;
	}

}
