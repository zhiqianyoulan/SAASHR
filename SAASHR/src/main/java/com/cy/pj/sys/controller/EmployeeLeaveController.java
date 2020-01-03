package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.EmployeeLeaveService;

@RestController
@RequestMapping("/empLeave/")
public class EmployeeLeaveController {
	@Autowired
	private EmployeeLeaveService employeeLeaveService;
	
	/**
	 * 查询待离职列表
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doFindEmpLeave")
	public JsonResult doFindEmpLeave(Integer pageCurrent) {
		return new JsonResult(
				employeeLeaveService.findEmpLeaList(0, ShiroUtils.getUser().getId(), pageCurrent));
	}

	@Transactional
	@RequestMapping("updateEmpLeave")
	 public JsonResult updateEmpLeave(Integer employeeId){
		 employeeLeaveService.updateEmpLeaStats(employeeId);
		 return new JsonResult("离职办理成功！");
		 
	 }	
	
	
}
