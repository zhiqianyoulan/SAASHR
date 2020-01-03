package com.cy.pj.sys.controller;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.EmpLeaveInfo;
import com.cy.pj.sys.service.EmployeeInfoService;
import com.cy.pj.sys.vo.EmpDetailInfo;

@RestController
@RequestMapping("/emp")
public class EmployeeInfoController {
	@Autowired
	private EmployeeInfoService employeeInfoService;
	
	@RequestMapping("/doFindEmpList")
	public JsonResult doFindEmpList(Integer stats,Integer pageCurrent) {
		Integer userId = ShiroUtils.getUser().getId();
		PageObject<Map<String, Object>> info = employeeInfoService.findEmpList(stats, userId,pageCurrent);
		return new JsonResult(info);
	}
	
	/**添加员工信息*/
	@RequestMapping("/doInsertEmpInfo")
	public JsonResult doInsertEmpInfo(EmpDetailInfo detail) {
		detail.setEmpCmpId(ShiroUtils.getUser().getId());
		employeeInfoService.insertEmpInfo(detail);
		return new JsonResult("insert ok");
	}
	
	/**修改员工信息*/
	@RequestMapping("/doUpdateEmpInfo")
	public JsonResult doUpdateEmpInfo(EmpDetailInfo detail) {
		System.out.println(detail);
		employeeInfoService.updateEmpInfo(detail);
		return new JsonResult("update ok");
	}
	
	@RequestMapping("/doFindEmpObject")
	public JsonResult findEmpObject(Integer id) {
		Map<String,Object> info  = employeeInfoService.findEmpObject(id);
		return new JsonResult(info);
	}
	
	
	@RequestMapping("/getTotalCount")
	public JsonResult getTotalCount() {
		Map<String, Integer> totalCount = employeeInfoService.getTotalCount(ShiroUtils.getUser().getId());
		return new JsonResult(totalCount);
	}
	
	/**
	 * 为员工办理离职
	 * @param entity
	 * @return
	 */
	@RequestMapping("insertLeaveInfo")
	public JsonResult insertLeaveInfo(EmpLeaveInfo entity) {
		employeeInfoService.updateEmpStats(entity);
		return new JsonResult("ok!!!");
	}
	
	
	
	
	
	
}
