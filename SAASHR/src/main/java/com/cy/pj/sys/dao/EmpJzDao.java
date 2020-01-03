package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.vo.EmpJzVo;


@Mapper
public interface EmpJzDao {
	/**查询总记录数*/
	int getRowCountss(@Param("empJobType")Integer empJobType,@Param("userId")Integer userId);
	
	/**查询兼职员工*/
	List<EmpJzVo> findEmpJzList(
			@Param("empJobType")Integer empJobType,
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);

}
