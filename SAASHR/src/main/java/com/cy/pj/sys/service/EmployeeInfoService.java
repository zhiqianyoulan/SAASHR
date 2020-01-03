package com.cy.pj.sys.service;

import java.util.Map;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.EmpInfo;
import com.cy.pj.sys.entity.EmpJobInfo;
import com.cy.pj.sys.entity.EmpLeaveInfo;
import com.cy.pj.sys.vo.EmpDetailInfo;

public interface EmployeeInfoService {
	
	/**查询在职员工*/
	 PageObject<Map<String, Object>> findEmpList(Integer stats,Integer userId,Integer pageCurrent);
	
	 /**添加员工*/
	 int insertEmpInfo(EmpDetailInfo detail);
	 
	 /**修改员工信息*/
	 int updateEmpInfo(EmpDetailInfo detail);
	    
	 /**
	  * 根据id查询员工对象
	  * @param id
	  * @return
	  */
	 Map<String,Object> findEmpObject(Integer id);
	 
	 /**
	  * 统计查询
	  * @param userId
	  * @return
	  */
	 
	 Map<String,Integer> getTotalCount(Integer userId);
	 
	 /**
	  * 为员工办理离职登记
	  * @param entity
	  * @return
	  */
	 int updateEmpStats(EmpLeaveInfo entity);
}
