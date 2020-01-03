package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.EmployeeLeaveInfoDao;
import com.cy.pj.sys.service.EmployeeLeaveInfoService;
@Service
public class EmployeeLeaveInfoServiceImpl implements EmployeeLeaveInfoService {
		@Autowired
		private PageProperties pageProperties;
		@Autowired
		private EmployeeLeaveInfoDao employeeLeaveInfoDao;
	
	@Override
	public PageObject<Map<String, Object>> findLeaveEmpList(Integer pageCurrent,Integer leaveStats,Integer userId) {
		if(leaveStats==null || leaveStats<0)
			throw new IllegalArgumentException("参数错误。。。");
		//1.验证参数合法性
		if(pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码值不正确!!!");	
		//2.基于参数名得到总记录数
		int rowCount = employeeLeaveInfoDao.getRowCount(leaveStats,userId);
		if(rowCount == 0)
			throw new ServiceException("没有对应的记录!!!");
		
		//3.基于条件查询当前页记录
		int pageSize=pageProperties.getPageSize();
		//指定位置
		int startIndex=(pageCurrent-1)*pageSize;
		//得到当前页记录
		List<Map<String, Object>> records = employeeLeaveInfoDao.findLeaveEmpList(startIndex, pageSize, leaveStats, userId);
		/*
		 * for(Map<String,Object> map : records) { Set<String> key = map.keySet();
		 * for(String key1 : key) { System.out.println(key); } }
		 */
		if(records==null || records.size()==0)
			throw new ServiceException("没有对应记录哦！");
		//4.封装查询结果
		PageObject<Map<String, Object>> result =  new PageObject<>(records, rowCount, pageCurrent, pageSize);
		return result;
	}

}
