package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
/**
 * 日志控制层对象
 * 核心业务
 * 1）请求数据处理（请求路径、请求方式、请求参数）
 * 2）相应数据处理（数据封装、数据转换、view跳转）
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/log/")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService; 
	
	/**
	 * 基于请求参数执行日志信息的获取
	 * @param username
	 * @param pageCurrent
	 * @return Json格式字符串
	 * 
	 * 说明：加入对方法参数有更高要求，可以使用@RequestParam注解对参数进行描述
	 */
	
//	@RequestMapping(value="doFindPageObjects",method = RequestMethod.GET)
//	@PostMapping("doFindPageObjects")
	@GetMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent) {
		PageObject<SysLog> pageObject=sysLogService.findPageObjects(username, pageCurrent);
		return new JsonResult(pageObject);
	}
	
	/**
	 *	局部异常处理
	 * @ExceptionHandler 用于描述异常处理方法，注解内部的异常类型，为方法能处理的异常类型
	 * 
	 */
//	@ExceptionHandler(RuntimeException.class)
	
	
	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {
		sysLogService.deleteObjects(ids);
		return new JsonResult("删除成功");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
