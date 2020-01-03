package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.EmpInfo;
import com.cy.pj.sys.entity.EmpJobInfo;
import com.cy.pj.sys.entity.EmpLeaveInfo;
import com.cy.pj.sys.vo.EmpDetailInfo;


@Mapper
public interface EmployeeInfoDao {
	/**
	 * 查询员工信息
	 * @param id
	 * @return
	 */
	Map<String,Object> findEmpObject(Integer id);
	
	/**查询在职员工总记录条数*/
	int getRowCount(Integer stats,Integer userId);
	
	/**查找在职员工*/
	List<Map<String,Object>> findEmpList(Integer startIndex,Integer pageSize,Integer stats,Integer userId);
	
	/**添加员工基本信息*/
	int insertEmpInfo(EmpInfo entity);
	
	/**添加员工职位信息*/
	int insertEmpJobInfo(EmpJobInfo jobEntity);
	
	/**修改员工基本信息*/
	int updataEmpInfo(EmpInfo entity);
	
	/**修改员工职位信息*/
	int updataEmpJobInfo(EmpJobInfo jobEntity);
	
	/**实习期人数，兼职人数，试用期人数*/
	List<Integer> getCountEmployeeType(Integer userId);

	/**统计男女员工人数*/
	List<Integer> getCountSex(Integer userId);
	
	/**
	 * 修改员工状态（离职登记）
	 * @param id
	 * @return
	 */
	int updateStats(Integer id);
	
	/**
	 * 为员工办理离职登记
	 * @param entity
	 * @return
	 */
	int insertLeaveInfo(EmpLeaveInfo entity);
	
}
