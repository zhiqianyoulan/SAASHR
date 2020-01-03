package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
@Data
public class EmpInfo implements Serializable{
	private static final long serialVersionUID = 2192972769171795305L;
	private Integer id;
	private String empName;
	private Integer empCmpId;
	private String empPhone;
	private String empCard;
	private String empEducation;
	private String empBirthday;
	private String empRegistered;
	private String empEmail;
	private String sex;
	public EmpInfo(Integer id, String empName, Integer empCmpId, String empPhone, String empCard, String empEducation,
			String empBirthday, String empRegistered, String empEmail, String sex) {
		super();
		this.id = id;
		this.empName = empName;
		this.empCmpId = empCmpId;
		this.empPhone = empPhone;
		this.empCard = empCard;
		this.empEducation = empEducation;
		this.empBirthday = empBirthday;
		this.empRegistered = empRegistered;
		this.empEmail = empEmail;
		this.sex = sex;
	}
	
}
