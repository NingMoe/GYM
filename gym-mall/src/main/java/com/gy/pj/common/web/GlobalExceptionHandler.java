package com.gy.pj.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gy.pj.common.vo.JsonResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	@ResponseBody
	public JsonResult doHandlerRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}
