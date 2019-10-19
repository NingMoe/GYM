package com.gy.pj.common.config;


import org.springframework.scheduling.annotation.AsyncConfigurer;

//@Configuration
public class SpringAsyncConfig implements AsyncConfigurer{
	/*
	 * @Override public Executor getAsyncExecutor() { ThreadPoolTaskExecutor
	 * taskExecutor = new ThreadPoolTaskExecutor(); taskExecutor.setCorePoolSize(2);
	 * taskExecutor.setMaxPoolSize(5); taskExecutor.setKeepAliveSeconds(60*10);
	 * taskExecutor.setThreadNamePrefix("db-service-thread-"); return taskExecutor;
	 * }
	 */
}
