package com.gym.thro;

/**
 * 对控制层的异常有效
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gym.vo.SysResult;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class SystemException {
	/**
	 * 异常处理器
	 * 只对运行时异常有效
	 * @return
	 */
	@ExceptionHandler(RuntimeException.class)
	public SysResult exception(Throwable throwable) {
		throwable.printStackTrace();
		log.info(throwable.getMessage());
		return SysResult.fail("调用失败");
	}
}
