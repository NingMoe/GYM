package com.gym.config;

import java.util.LinkedHashMap;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class SpringShiroConfig {
	
	  @Bean public CacheManager newCacheManager() { return new
	 MemoryConstrainedCacheManager(); }
	 

	@Bean
	public SecurityManager newSecurityManager(@Autowired Realm realm, @Autowired CacheManager cacheManager ) {
		DefaultWebSecurityManager sManager = new DefaultWebSecurityManager();
		sManager.setRealm(realm); 
		sManager.setCacheManager(cacheManager);
		 /* sManager.setRememberMeManager(newRememberMeManager());
		 * sManager.setSessionManager(sessionManager());
		 */
		return sManager;
	}

	/*
	 * public SessionManager sessionManager() { DefaultWebSessionManager sManager =
	 * new DefaultWebSessionManager(); sManager.setGlobalSessionTimeout(60*60*1000);
	 * return sManager; }
	 */

	/*
	 * public SimpleCookie newCookie() { SimpleCookie c = new
	 * SimpleCookie("rememberMe"); c.setMaxAge(10 * 60); return c; }
	 * 
	 * public CookieRememberMeManager newRememberMeManager() {
	 * CookieRememberMeManager cManager = new CookieRememberMeManager();
	 * cManager.setCookie(newCookie()); return cManager; }
	 */

	@Bean("shiroFilterFactory")
	public ShiroFilterFactoryBean newShiroFilterFactoryBean(@Autowired SecurityManager securityManager) {
		ShiroFilterFactoryBean sfBean = new ShiroFilterFactoryBean();
		sfBean.setSecurityManager(securityManager);
		sfBean.setLoginUrl("/doLoginUI");
		// 定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
		LinkedHashMap<String, String> map = new LinkedHashMap<>();// 能够保证key的添加顺序
		// 静态资源允许匿名访问:"anon"
		map.put("/bower_components/**", "anon");
		map.put("/css/**", "anon");
		map.put("/fonts/**", "anon");
		map.put("/images/**", "anon");
		map.put("/js/**", "anon");
		map.put("/lib/**", "anon");
		map.put("/user/doLogin", "anon");
		map.put("/doLogout", "logout");
		// 除了匿名访问的资源,其它都要认证("authc")后访问
		map.put("/**", "authc");// 顺序不能乱,允许的要放在不允许的上边
		sfBean.setFilterChainDefinitionMap(map);
		return sfBean;
	}


	@Bean("lifecycleBeanPostProcessor") public LifecycleBeanPostProcessor
	newLifecycleBeanPostProcessor() { return new LifecycleBeanPostProcessor(); }

	 @DependsOn("lifecycleBeanPostProcessor")
	  
	  @Bean public DefaultAdvisorAutoProxyCreator
	  newDefaultAdvisorAutoProxyCreator() { return new
	  DefaultAdvisorAutoProxyCreator(); }
	
	  @Bean public AuthorizationAttributeSourceAdvisor
	 newAuthorizationAttributeSourceAdvisor(
	  
	  @Autowired SecurityManager securityManager) {
	  AuthorizationAttributeSourceAdvisor advisor = new
	  AuthorizationAttributeSourceAdvisor();
	  advisor.setSecurityManager(securityManager); return advisor; }
	 
}
