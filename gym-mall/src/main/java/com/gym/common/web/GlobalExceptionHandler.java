package com.gym.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gym.common.vo.JsonResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	@ResponseBody
	public JsonResult doHandlerRuntimeException(RuntimeException e) {
		e.printStackTrace();
		return new JsonResult(e);
	}
}
