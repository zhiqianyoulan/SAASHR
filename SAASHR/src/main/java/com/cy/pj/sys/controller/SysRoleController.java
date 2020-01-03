package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;

@RestController
@RequestMapping("/role/")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(String name,Integer pageCurrent) {
			 return new JsonResult(sysRoleService.findPageObjects(name,pageCurrent));
		 }
	
	/**删除角色菜单数据信息*/
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		sysRoleService.deleteObject(id);
		return new JsonResult("delete ok");
	}
	
	/**保存角色菜单信息及关系数据*/
	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(SysRole entity, Integer[] menuIds) {
		sysRoleService.saveObject(entity, menuIds);
		return new JsonResult("save ok");
	}
	
	/**修改角色菜单信息及其关系数据*/
	@RequestMapping("doFindObjectById")
	public JsonResult doFindObjectById(Integer id) {
		
		return new JsonResult(sysRoleService.findObjectById(id));
	}
	
	/**更新角色菜单及其关系数据*/
	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysRole entity,Integer[ ] menuIds ) {
		return new JsonResult(sysRoleService.updateObject(entity, menuIds));
	}
	
	/**获取角色id，name属性*/
	@RequestMapping("doFindRoles")
	public JsonResult doFindRoles() {
		return new JsonResult(sysRoleService.findObjects());
	}
	
	
	
}


