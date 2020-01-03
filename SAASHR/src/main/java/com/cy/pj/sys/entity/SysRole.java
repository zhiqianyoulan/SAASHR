package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class SysRole implements Serializable{

	/**
	 * 封装角色菜单及其对应关系数据
	 */
	private static final long serialVersionUID = 8094272493294939469L;
	private Integer id;
	private String name;
	private String note;//备注
	private Date createdTime;
	private Date modifiedTime;//修改时间
	private String createdUser;//创建用户
	private String modifiedUser;//修改用户
}
