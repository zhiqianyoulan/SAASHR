package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
/**
 * 通过此对象封装从数据库中查询到的角色菜单记录
 * @author Administrator
 *
 */
@Data
public class SysRoleMenuVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8736534314621626350L;
	
	private Integer id;
	/**角色名称*/
	private String name;
	/**角色备注*/
	private String note;
	/**角色对应的菜单id*/
	private List<Integer> menuIds;
}
