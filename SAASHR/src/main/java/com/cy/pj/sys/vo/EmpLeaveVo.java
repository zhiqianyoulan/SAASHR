package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class EmpLeaveVo implements Serializable{
	private static final long serialVersionUID = -6185808066095919538L;
	private Integer id;
	private Integer employeeId;
	private String ename;
	private String deptName;
	private String joinTime;
	private String empCard;
	private String empPhone;
	private String leavetime;
	private String leaveReason;
	private Integer leaveStats=0;//未办理：0 默认
}
