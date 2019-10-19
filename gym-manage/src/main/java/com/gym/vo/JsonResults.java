package com.gym.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class JsonResults<T> {
	
	@JsonInclude(value=Include.ALWAYS)
	private Integer state;
	@JsonInclude(value=Include.NON_NULL)
	private String message;
	@JsonInclude(value=Include.ALWAYS)
	private T data;

	public JsonResults() {
	}

	public JsonResults(Integer state) {
		this.state = state;
	}
	
	public JsonResults(Integer state, String message) {
		super();
		this.state = state;
		this.message = message;
	}

	public JsonResults(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public JsonResults(String message) {
		this.message = message;
	}

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
