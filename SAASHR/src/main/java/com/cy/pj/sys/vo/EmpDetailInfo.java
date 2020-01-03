package com.cy.pj.sys.vo;

import java.io.Serializable;
import java.util.Date;
import com.cy.pj.sys.entity.EmpInfo;
import com.cy.pj.sys.entity.EmpJobInfo;
import com.cy.pj.sys.entity.SysDept;

import lombok.Data;
@Data
public class EmpDetailInfo implements Serializable{
	private static final long serialVersionUID = -8132540233543844484L;
	private Integer infoId;
	private String empName;//员工姓名
	private String sex;//性别
	private Integer empCmpId;//企业（用户）id
	private String empPhone;//联系方式
	private String empCard;//身份证
	private String empEducation;//学历
	private String empBirthday;//生日  
	private String empRegistered;//户口所在地
	private String empEmail;//邮箱
	
	private Integer jobInfoId;//职位表id
//	private EmpInfo employeeId;// ==EmpInfo infoId
	private Integer empDeptId;//部门
	private String empJoinTime;//入职时间
	private String empJobType;//员工类型（正式员工、试用期、实习、兼职）
	private Integer empStats;//员工状态（在职，待离职）
	private String empBankNo;//银行卡号
	private String empBankName;//发卡行
	private String empBankAddr;//银行所在地
	
	
}
