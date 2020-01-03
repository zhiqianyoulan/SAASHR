package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.EmployeeSyService;

@RestController
@RequestMapping("/empSy/")
public class EmployeeSyController {
	@Autowired
	private EmployeeSyService employeeSyService;
	@RequestMapping("doFindEmpSy")
	public JsonResult doFindEmpLeave(Integer empJobType,Integer pageCurrent) {
		return new JsonResult(
				employeeSyService.findEmpSyList(empJobType, ShiroUtils.getUser().getId(), pageCurrent));
	}

	@RequestMapping("updateEmpSy")
	 public JsonResult updateEmpLeave(Integer employeeId){
		employeeSyService.updateEmpSyStats(employeeId);
		 return new JsonResult("转正办理成功！");
		 
	 }	 
}
