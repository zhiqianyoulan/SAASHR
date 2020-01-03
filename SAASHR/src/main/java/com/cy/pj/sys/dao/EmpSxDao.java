package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.vo.EmpSxVo;

@Mapper
public interface EmpSxDao {
	
	/**查询总记录数*/
	int getRowCounts(@Param("empJobType")Integer empJobType,@Param("userId")Integer userId);
	
	/**查询实习员工*/
	List<EmpSxVo> findEmpSxList(
			@Param("empJobType")Integer empJobType,
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
}
