package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class EmpSxVo implements Serializable{
	private static final long serialVersionUID = -3801816813034830001L;
	private Integer id;
	private Integer employeeId;
	private String ename;
	private String deptName;
	private String joinTime;
	private String empCard;
	private String empPhone;
	private Integer empJobType;//取实习的：2
}
