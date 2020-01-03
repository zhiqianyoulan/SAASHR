package com.cy.pj.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.service.EmployeeLeaveInfoService;

/**
 * 
 * @author lv
 *
 */
@RestController
@RequestMapping("/emp")
public class EmployeeLeaveInfoController {
	@Autowired
	private EmployeeLeaveInfoService employeeLeaveInfoService;
	
	@RequestMapping("/doFindLeaveEmpList")
	public JsonResult doFindLeaveEmpList(Integer leaveStats,Integer pageCurrent) {
		Integer userId = ShiroUtils.getUser().getId();
		PageObject<Map<String, Object>> result = employeeLeaveInfoService.findLeaveEmpList(pageCurrent, leaveStats, userId);
		return new JsonResult(result);
	}
}
