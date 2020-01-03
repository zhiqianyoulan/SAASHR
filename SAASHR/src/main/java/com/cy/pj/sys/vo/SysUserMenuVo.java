package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class SysUserMenuVo implements Serializable{
	private static final long serialVersionUID = -6532648335943768546L;
	private Integer id;
	private String name;
	private String url;
	/**当前菜单的子菜单*/
	private List<SysUserMenuVo> childMenus;
}
