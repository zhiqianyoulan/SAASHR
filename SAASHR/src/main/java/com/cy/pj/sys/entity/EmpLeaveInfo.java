package com.cy.pj.sys.entity;

import java.io.Serializable;
import lombok.Data;
@Data
public class EmpLeaveInfo implements Serializable{

	private static final long serialVersionUID = 1329437776856181359L;
	private Integer employeeId;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String leaveTime;
	private String leaveType;
	private String leaveReason;
	private Integer leaveStats;
	
	public EmpLeaveInfo(Integer employeeId, String leaveTime, String leaveType, String leaveReason,
			Integer leaveStats) {
		super();
		this.employeeId = employeeId;
		this.leaveTime = leaveTime;
		this.leaveType = leaveType;
		this.leaveReason = leaveReason;
		this.leaveStats = leaveStats;
	}
	
}
