package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.vo.EmployeeSyVo;

public interface EmployeeSyService {
	/**查询试用期员工信息*/
	PageObject<EmployeeSyVo> findEmpSyList(Integer empJobType,Integer userId,Integer pageCurrent);
	
	/**更新试用期员工状态*/
	int updateEmpSyStats(Integer employeeId);
}
