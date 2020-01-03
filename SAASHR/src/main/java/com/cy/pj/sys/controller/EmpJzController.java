package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.EmpJzService;

@RestController
@RequestMapping("/empJz/")
public class EmpJzController {
@Autowired
private EmpJzService empJzService;
@RequestMapping("doFindEmpJz")
public JsonResult doFindEmpSx(Integer empJobType,Integer pageCurrent) {
	return new JsonResult(
			empJzService.findEmpJzList(empJobType, ShiroUtils.getUser().getId(), pageCurrent));
}
}
