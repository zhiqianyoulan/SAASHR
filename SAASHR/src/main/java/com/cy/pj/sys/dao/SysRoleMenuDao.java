package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysRoleMenuDao {
	/**基于菜单id删除角色和菜单关系数据*/
	int deleteObjectsByMenuId(Integer menuId);
	
	/**基于角色关系删除关系数据*/
	int deleteObjectsByRoleId(Integer id);
	
	/**将角色菜单关系数据添加到数据库*/
	int insertObjects(@Param("roleId")Integer roleId,@Param("menuIds")Integer[ ] menuIds);
	
	/**基于id查询角色及其相关信息*/
	int findMenuIdsByRoleId(Integer id);
	
	/**基于多个角色id查找菜单id*/
	List<Integer> findMenuIdsByRoleIds(@Param("roleIds")Integer[ ] roleIds);
}
