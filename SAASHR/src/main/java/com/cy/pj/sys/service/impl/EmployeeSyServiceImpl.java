package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.EmployeeSyDao;
import com.cy.pj.sys.service.EmployeeSyService;
import com.cy.pj.sys.vo.EmployeeSyVo;
@Service
public class EmployeeSyServiceImpl implements EmployeeSyService {
	@Autowired
	private EmployeeSyDao employeeSyDao;
	@Autowired
	private PageProperties pageProperties;
	@Override
	public PageObject<EmployeeSyVo> findEmpSyList(Integer empJobType, Integer userId, Integer pageCurrent) {
		//1.参数校验
				if(pageCurrent==null||pageCurrent<1)
					throw new IllegalArgumentException("当前页码值不正确");
				//2.查询总记录数
				int rowCount=employeeSyDao.getRowCount3(empJobType, userId);
				if(rowCount==0)
					throw new ServiceException("记录不存在");
				//3.查询当前页记录
				int pageSize=pageProperties.getPageSize();
				int startIndex=(pageCurrent-1)*pageSize;
				List<EmployeeSyVo> records=employeeSyDao.findEmpSyList(empJobType, userId, startIndex, pageSize);
				//4.封装查询结果并返回
				return new PageObject<>(records, rowCount, pageCurrent, pageSize);
	}
	
	@Override
	@CacheEvict(value="empList",allEntries = true)
	public int updateEmpSyStats(Integer employeeId) {
		if(employeeId==null||employeeId<1)
			throw new IllegalArgumentException("无效参数异常");
		int rows = employeeSyDao.updateEmpSyStats(employeeId);
		//3.返回结果
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

}
