package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

public interface SysLogService {
	/** 分页查询用户行为日志信息
	  * @param name 基于条件查询时的参数名
      * @param pageCurrent 当前的页码值
      * @return 当前页记录+分页信息
	 * 
	 */ 
	PageObject<SysLog> findPageObjects(String username,Integer pageCurrent);
	
	/**
	 * 基于ｉｄ执行删除日志操作
	 */
	int deleteObjects(Integer... ids);
	
	/**
	 * 新增用户日志信息
	 * @param entity
	 * @return
	 */
	void saveObject(SysLog entity);
}
