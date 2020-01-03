package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class EmployeeSyVo implements Serializable{
	private static final long serialVersionUID = -5452531296557254351L;
	private Integer id;
	private Integer employeeId;
	private String ename;
	private String deptName;
	private String joinTime;
	private String empCard;
	private String empPhone;
	private Integer empJobType;//取试用期员工的：1
}

