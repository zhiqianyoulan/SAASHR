package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.PageObject;

public interface EmployeeLeaveInfoService {
	
	/**查找离职员工*/
	PageObject<Map<String,Object>> findLeaveEmpList(Integer pageCurrent,Integer leaveStats,Integer userId);
	
}
