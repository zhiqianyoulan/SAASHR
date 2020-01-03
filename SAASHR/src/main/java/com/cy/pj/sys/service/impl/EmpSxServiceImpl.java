package com.cy.pj.sys.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.EmpSxDao;
import com.cy.pj.sys.service.EmpSxService;
import com.cy.pj.sys.vo.EmpSxVo;
@Service
public class EmpSxServiceImpl implements EmpSxService {
	@Autowired
	private PageProperties pageProperties;
	@Autowired
	private EmpSxDao empSxDao;

	@Override
	public PageObject<EmpSxVo> findEmpSxList(Integer empJobType, Integer userId, Integer pageCurrent) {
		//1.参数校验
				if(pageCurrent==null||pageCurrent<1)
					throw new IllegalArgumentException("当前页码值不正确");
				//2.查询总记录数
				int rowCount=empSxDao.getRowCounts(empJobType, userId);
				if(rowCount==0)
					throw new ServiceException("记录不存在");
				//3.查询当前页记录
				int pageSize=pageProperties.getPageSize();
				int startIndex=(pageCurrent-1)*pageSize;
				List<EmpSxVo> records=empSxDao.findEmpSxList(empJobType, userId, startIndex, pageSize);
				//4.封装查询结果并返回
				return new PageObject<>(records, rowCount, pageCurrent, pageSize);
				
	}

}
