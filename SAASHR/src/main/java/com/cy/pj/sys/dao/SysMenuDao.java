package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.vo.SysUserMenuVo;

/**
 * @CacheNamespaceRef（引用namespace对应的路径）引用mapper文件中设置的cache缓存
 * @author Administrator
 * @CacheNamespaceRef

 */
@Mapper
public interface SysMenuDao {
	/***
	 * 查询所有菜单以及上级菜单
	 * 一行记录对应一个map
	 * 多行记录存储到list集合中
	 * @return
	 */
	List<Map<String,Object>> findObjects();
	
	/**基于菜单id查询子菜单记录*/
	int getChildCount(Integer id);
	/**基于菜单id删除自身菜单记录*/
	int deleteObject(Integer id);
	
	/**查询上级菜单相关信息*/
//	@Select("select id,name,perentId from sys_menus")
	List<Node> findZtreeMenuNodes();
	
	/**新增菜单信息*/
	int insertObject(SysMenu entity);
	
	/**更新菜单数据*/
	int updateObject(SysMenu entity);
	
	/**基于菜单id查找权限标识的方法*/
	List<String> findPermissions(@Param("menuIds")Integer[ ] menuIds);
	
	/**
	 * 查询用户菜单（默认是最高权限用户的所有菜单）
	 * @return
	 */
	public List<SysUserMenuVo> findUserMenus();
	
}
