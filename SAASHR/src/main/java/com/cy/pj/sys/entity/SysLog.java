package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class SysLog implements Serializable {//实现序列化接口，可以将数据序列化到磁盘中，也可以将数据从磁盘中恢复
	private static final long serialVersionUID = 1L;/*此id为序列化唯一标识，尤其在反序列化时，对id要求会更严格*/
	private Integer id;
	//用户名
	private String username;
	//用户操作
	private String operation;
	//请求方法
	private String method;
	//请求参数
	private String params;
	//执行时长（毫秒）
	private Long time;
	//IP地址
	private String ip;
	//创建时间
	private Date createdTime;
}
