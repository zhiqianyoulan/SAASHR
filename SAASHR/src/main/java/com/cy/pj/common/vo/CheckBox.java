package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class CheckBox implements Serializable{
	/**
	 * 封装角色id，角色名信息
	 */
	private static final long serialVersionUID = 5065823170856122977L;
	private Integer id;
	private String name;
}
