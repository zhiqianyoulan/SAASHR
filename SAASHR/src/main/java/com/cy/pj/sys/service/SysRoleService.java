package com.cy.pj.sys.service;


import java.util.List;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	/**
	 * 基于条件查询当前页信息
	 * @param name
	 * @param pageCurrent
	 * @return
	 */
	 PageObject<SysRole> findPageObjects(String name,Integer pageCurrent);
	 
	 /**
	  * 基于角色id进行删除角色以及角色对应关系数据
	  * @param id
	  * @return
	  */
	 int deleteObject(Integer id);
	 
	 /**
	  * 保存角色和菜单关系数据数据
	  * @param entity
	  * @param menuIds
	  * @return
	  */
	 int saveObject(SysRole entity,Integer[ ]menuIds);
	 
	 /**
	  * 基于id查询对应角色及其相关信息
	  * @param id
	  * @return
	  */
	 SysRoleMenuVo findObjectById(Integer id);
	 
	 /**
	  * 更新角色自身信息以及对应关系数据
	  * @param entity
	  * @param menuIds
	  * @return
	  */
	 int updateObject(SysRole entity,Integer[ ] menuIds);
	 
	 /**
	  * 获取角色id和name属性
	  * @return
	  */
	 List<CheckBox> findObjects();
	 
}
