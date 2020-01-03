package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.vo.EmpJzVo;


public interface EmpJzService {
/**查询兼职员工*/
	PageObject<EmpJzVo> findEmpJzList(Integer empJobType,Integer userId,Integer pageCurrent);
}
