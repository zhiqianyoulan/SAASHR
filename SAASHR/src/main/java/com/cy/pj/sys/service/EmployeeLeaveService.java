package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.vo.EmpLeaveVo;

public interface EmployeeLeaveService {
	/**查询待离职员工信息*/
	PageObject<EmpLeaveVo> findEmpLeaList(Integer leaveStats,Integer userId,Integer pageCurrent);
	
	/**更新待离职员工状态*/
	int updateEmpLeaStats(Integer employeeId);


}
