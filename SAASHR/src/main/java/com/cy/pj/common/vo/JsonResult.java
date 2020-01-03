package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.Data;
@Data
public class JsonResult implements Serializable {
	private static final long serialVersionUID = 2080943344863436345L;
	
	//状态码
	private int state=1;//1表示success，0表示ERROR
	//状态信息
	private String message="ok";
	//正确数据
	private Object data;
	public JsonResult() {}
	public JsonResult(String message) {
		this.message=message;
	}
	
	//一般查询时调用，封装查询结果
	public JsonResult(Object data) {
		this.data=data;
	}
	
	//出现异常时调用
	public JsonResult(Throwable t) {
		this.state=0;//异常
		this.message=t.getMessage();
	}
}
