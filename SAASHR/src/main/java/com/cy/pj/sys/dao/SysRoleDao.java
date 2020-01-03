package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.vo.SysRoleMenuVo;
@Mapper
/**定义角色数据层接口对象，通过将此对象保证给业务层以提供角色数据操作*/
public interface SysRoleDao {
	/**
	 * 基于条件查询juese总记录数
	 * @param name
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	
	/**
	 * 基于条件分页查询角色信息
	 * @param name
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<SysRole> findPageObjects(@Param("name")String name,
													@Param("startIndex")Integer startIndex,
													@Param("pageSize")Integer pageSize);
	/**
	 * 基于id删除角色自身信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 将角色自身信息保存到数据库
	 * @param entity
	 * @return
	 */
	int insertObject(SysRole entity);
	
	/**
	 * 基于id查询角色自身数据信息
	 * @param id
	 * @return
	 */
//	@Select("select id,name,note from sys_roles where id=#{id}")
	SysRoleMenuVo findObjectById(Integer id);
	
	/**
	 * 更新角色自身数据
	 * @param entity
	 * @return
	 */
	int updateObject(SysRole entity);
	
	/**
	 * 查询所有角色id，name，封装到checkbox
	 * @return
	 */
	List<CheckBox> findObjects();
	
}
