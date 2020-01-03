package com.cy.pj.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.util.IPUtils;
import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
//@Order(3)
@Component
@Aspect
@Slf4j
public class SysLogAspect {
	@Pointcut("bean(sysUserServiceImpl)")
	public void logPointCut() {}
	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint jp)
	throws Throwable{
		try {
			long t1=System.currentTimeMillis();
			Object result = jp.proceed();
			long t2=System.currentTimeMillis();
			 saveUserLog(jp,(t2-t1));//为什么把连接点对象传到方法中？
			 //因为可以通过连接点对象获得方法信息
			return result;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}
	
	@Autowired
	private SysLogService sysLogService;  
	private void saveUserLog(ProceedingJoinPoint jp, long time) throws Exception {
		//1.获取用户行为日志
		//1.1获取目标方法对象（class，jp）
		
		//1.1.1获取方法签名（通过连接点获取）
		MethodSignature ms =(MethodSignature)jp.getSignature();
		
		//获取目标方法的类的类型
		Class<?> targetCls = jp.getTarget().getClass();
		
		//获取目标方法对象（通过目标方法的类型基于方法名，和参数类型获取目标方法对象）
		Method targetMethod = targetCls.getDeclaredMethod(ms.getName(),ms.getParameterTypes());
		
		//获取目标方法上RequiredLog注解中定义的操作名
		String operation="operation";
		//获取目标方法上的注解
		RequiredLog requiredLog = targetMethod.getAnnotation(RequiredLog.class);
		if(requiredLog != null) {
			//获取目标方法注解中的属性值
			operation=requiredLog.value();
		}
		
		//获取目标方法对象对应的类名，方法名
		String targetClsMethod=targetCls.getName()+"."+targetMethod.getName();
		
		//获得方法执行的实际参数（先获取到目标方法的参数对象，然后将对象转化为json格式的字符串）
		String params = new ObjectMapper().writeValueAsString(jp.getArgs());
		
		//封装日志
		SysLog log = new SysLog();
		log.setIp(IPUtils.getIpAddr());		
		log.setUsername(ShiroUtils.getUsername());
		log.setOperation(operation);//操作（注解中自定义定义的属性值）
		log.setMethod(targetClsMethod);//包名.类名.方法名
		log.setParams(params);//参数
		log.setTime(time);
		log.setCreatedTime(new Date());
		//将日志存储到数据库
		sysLogService.saveObject(log);
	}
	
}


