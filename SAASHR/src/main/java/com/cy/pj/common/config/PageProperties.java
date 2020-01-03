package com.cy.pj.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
/*@ConfigurationProperties 注解描述的类可以交给spring容器管理，并且可以从配置文件中
 * 读取配置信息，
 * 
 * */
@Data
@ConfigurationProperties(prefix = "db.page")
public class PageProperties {
	private Integer pageSize=2;
}
