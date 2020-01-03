package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.vo.EmpLeaveVo;

@Mapper
public interface EmployeeLeaveDao {
	/**查询总记录数*/
	int getRowCount(@Param("leaveStats")Integer leaveStats,@Param("userId")Integer userId);
	/**查询待离职员工信息*/
	List<EmpLeaveVo> findEmpLeaList(
			@Param("leaveStats")Integer leaveStats,
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);

	/**更新待离职员工状态,办理离职 */
	int updateEmpLeaStats(Integer employeeId);
	
	/**更改在职员工的的状态*/
	int updateEmpListStats(Integer employeeId);
	
	
}
