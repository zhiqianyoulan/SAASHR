package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EmpJobInfo implements Serializable{
	private static final long serialVersionUID = -6903064096002249277L;
	private Integer id;
	private Integer employeeId;
	private Integer empDeptId;
	private String empJoinTime;
	private String empJobType;
	private Integer empStats;
	private String empBankNo;
	private String empBankName;
	private String empBankAddr;
	public EmpJobInfo(Integer id, Integer employeeId, Integer empDeptId, String empJoinTime, String empJobType,
			Integer empStats, String empBankNo, String empBankName, String empBankAddr) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.empDeptId = empDeptId;
		this.empJoinTime = empJoinTime;
		this.empJobType = empJobType;
		this.empStats = empStats;
		this.empBankNo = empBankNo;
		this.empBankName = empBankName;
		this.empBankAddr = empBankAddr;
	}
	
	
}
