package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;


public interface SysMenuService {
	List<Map<String,Object>> findObjects();
	
	int deleteObject(Integer id);
	
	/**查询菜单讯息*/
	List<Node> findZtreeMenuNodes();
	
	/**新增菜单对象*/
	int saveObject(SysMenu entity);

	/**修改更新菜单数据*/
	int updateObject(SysMenu entity);
	

}
