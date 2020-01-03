package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.vo.EmpSxVo;


public interface EmpSxService {
/**查询实习员工*/
	PageObject<EmpSxVo> findEmpSxList(Integer empJobType,Integer userId,Integer pageCurrent);
}
