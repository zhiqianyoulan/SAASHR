package com.cy.pj.sys.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.EmployeeLeaveDao;
import com.cy.pj.sys.service.EmployeeLeaveService;
import com.cy.pj.sys.vo.EmpLeaveVo;
import com.cy.pj.sys.vo.SysUserDeptVo;

@Service
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {
	@Autowired
	private EmployeeLeaveDao employeeLeaveDao;
	@Autowired
	private PageProperties pageProperties;

	/**查询待离职员工信息*/
	@Override
	public PageObject<EmpLeaveVo> findEmpLeaList(Integer leaveStats, Integer userId, Integer pageCurrent) {
		//1.参数校验
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值不正确");
		//2.查询总记录数
		int rowCount=employeeLeaveDao.getRowCount(leaveStats, userId);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		//3.查询当前页记录
		int pageSize=pageProperties.getPageSize();
		int startIndex=(pageCurrent-1)*pageSize;
		List<EmpLeaveVo> records=employeeLeaveDao.findEmpLeaList(leaveStats, userId, startIndex, pageSize);
		//4.封装查询结果并返回
		return new PageObject<>(records, rowCount, pageCurrent, pageSize);
	}

	/** 更新待离职员工状态 */
	@Override
	@CacheEvict(value="empList",allEntries = true)
	public int updateEmpLeaStats(Integer employeeId) {
		if(employeeId==null||employeeId<1)
			throw new IllegalArgumentException("无效参数异常");
		employeeLeaveDao.updateEmpListStats(employeeId);
		int rows = employeeLeaveDao.updateEmpLeaStats(employeeId);

		//3.返回结果
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}
}
