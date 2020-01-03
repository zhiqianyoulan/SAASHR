package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogDao sysLogDao;
	
	@Autowired
	private PageProperties pageProperties;
	
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		//1.验证参数合法性
		if(pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码值不正确!!!");	
		//2.基于参数名得到总记录数
		int rowCount = sysLogDao.getRowCount(username);
		if(rowCount == 0)
			throw new ServiceException("没有对应的记录!!!");
		
		//3.基于条件查询当前页记录
		int pageSize=pageProperties.getPageSize();
		//指定位置
		int startIndex=(pageCurrent-1)*pageSize;
		//得到当前页记录
		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
		
		//4.封装查询结果
		PageObject<SysLog> po =  new PageObject<>(records, rowCount, pageCurrent, pageSize);
		/*
		 * PageObject<SysLog> pageObject = new PageObject<>();
		 * pageObject.setPageCurrent(pageCurrent); pageObject.setPageSize(pageSize);
		 * pageObject.setRowCount(rowCount); pageObject.setRecords(records);
		 * pageObject.setPageCount((rowCount-1)/pageSize+1);
		 */
		return po;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		if(ids == null || ids.length == 0) 
			throw new IllegalArgumentException("请选择要删除的id");
			int rows;
			try {
				rows=sysLogDao.deleteObjects(ids);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServiceException("系统故障，正在恢复中...");
			}
			if(rows == 0)
				throw new ServiceException("记录不存在...");
			return rows;
	}

	/***/
//	@Async
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveObject(SysLog entity) {
		  sysLogDao.insertObject(entity); 
//		  try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
