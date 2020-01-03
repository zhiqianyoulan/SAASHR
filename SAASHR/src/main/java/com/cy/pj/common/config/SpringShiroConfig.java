package com.cy.pj.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author Administrator
 *
 */
@Configuration
public class SpringShiroConfig {
	/**添加会话管理配置*/
	@Bean   
	public SessionManager sessionManager() {
			 DefaultWebSessionManager sManager= new DefaultWebSessionManager();
			 sManager.setGlobalSessionTimeout(60*60*1000);
			 return sManager;
		 }
	
	/**配置记住我*/
	@Bean
	public RememberMeManager rememberMeManager() {
		CookieRememberMeManager cManager = new CookieRememberMeManager();
		SimpleCookie cookie = new SimpleCookie("rememberMe");
		cookie.setMaxAge(600);
		cManager.setCookie(cookie);
		return cManager;
	}
	
	/**配置缓存Bean对象*/
	@Bean
	public CacheManager shiroCacheManager() {
		return new MemoryConstrainedCacheManager();
	}
	
	/**添加SecurityManager配置*/
	@Bean
	public SecurityManager securityManager() {
			 DefaultWebSecurityManager sManager=new DefaultWebSecurityManager();
			 return sManager;
	}
	
	/**添加过滤器工厂对象，通过此对象设置资源匿名访问、认证访问*/
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactory (SecurityManager securityManager) {
			 ShiroFilterFactoryBean sfBean=new ShiroFilterFactoryBean();
			 sfBean.setSecurityManager(securityManager);
			 sfBean.setLoginUrl("/doLoginUI");//添加一个登录的url
			 //定义map指定请求过滤规则(哪些资源允许匿名访问,哪些必须认证访问)
			 LinkedHashMap<String,String> map=new LinkedHashMap<>();
			 //设置允许匿名访问的资源，静态资源允许匿名访问:"anon"
			 map.put("/bower_components/**","anon");
			 map.put("/build/**","anon");
			 map.put("/dist/**","anon");
			 map.put("/plugins/**","anon");
//			 map.put("/user/doIndexUI", "anon");
			 map.put("/user/doLogin", "anon");//登录操作匿名访问的配置
			 map.put("/doLogout", "logout");//退出操作配置实现
			 //设置必须认证才能访问的资源，除了匿名访问的资源,其它都要认证("authc")后访问
			 map.put("/**","user");
			 sfBean.setFilterChainDefinitionMap(map);
			 return sfBean;
		 }
	
	/**把写的realm注入给SecurityManager对象*/
	@Bean
	public SecurityManager securityManager(Realm realm,CacheManager cacheManager,
			 RememberMeManager rememberManager,SessionManager sessionManager) {
			 DefaultWebSecurityManager sManager=new DefaultWebSecurityManager();
			 sManager.setRealm(realm);
			 sManager.setCacheManager(cacheManager);
			 sManager.setRememberMeManager(rememberManager);
			 sManager.setSessionManager(sessionManager);
			 return sManager;
	}
	/**授权配置*/
	 @Bean
	 public AuthorizationAttributeSourceAdvisor  newAuthorizationAttributeSourceAdvisor(@Autowired SecurityManager securityManager) {
		 AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
		 advisor.setSecurityManager(securityManager);
	 	 return advisor;
	 }
}
