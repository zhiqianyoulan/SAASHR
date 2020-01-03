package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.vo.EmpLeaveVo;
import com.cy.pj.sys.vo.EmployeeSyVo;

@Mapper
public interface EmployeeSyDao {
	/**查询总记录数*/
	int getRowCount3(@Param("empJobType")Integer empJobType,@Param("userId")Integer userId);
	/**查询试用期员工信息*/
	List<EmployeeSyVo> findEmpSyList(
			@Param("empJobType")Integer empJobType,
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);

	/**更新试用期员工状态,办理离职 */
	int updateEmpSyStats(Integer employeeId);

}
