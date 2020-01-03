package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeLeaveInfoDao {
	/**查询离职员工总记录条数*/
	int getRowCount(Integer leaveStats,Integer userId);
	
	/**查找离职员工*/
	List<Map<String,Object>> findLeaveEmpList(Integer startIndex,Integer pageSize,Integer leaveStats,Integer userId);
	
	/**查询本月离职人数*/
	int leaveCountThisMonth(Integer userId);
}
