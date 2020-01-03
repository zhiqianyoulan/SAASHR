package com.cy.pj.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

@Controller
@RequestMapping("/menu")
public class SysMenuController {
	/**查询所有菜单和上级菜单信息*/
	@Autowired
	private SysMenuService sysMenuService;
	@ResponseBody
	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects(){
		 List<Map<String,Object>> list = sysMenuService.findObjects();
		return new JsonResult(list);
	}
	
	
	/**删除菜单数据*/
	@ResponseBody
	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		int deleteObject = sysMenuService.deleteObject(id);
		return new JsonResult(deleteObject);
	}
	
	/**获取菜单节点对象*/
	@RequestMapping("doFindZtreeMenuNodes")
	 @ResponseBody
	 public JsonResult doFindZtreeMenuNodes(){
		 return new JsonResult(
		 sysMenuService.findZtreeMenuNodes());
	 }
	
	/**新增菜单数据请求和响应逻辑*/
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysMenu entity){
		sysMenuService.saveObject(entity);
		return new JsonResult("save ok");
	}
	
	/**修改更新菜单数据请求*/
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysMenu entity){
		sysMenuService.updateObject(entity);
		return new JsonResult("update ok");
	}
	
	
}
