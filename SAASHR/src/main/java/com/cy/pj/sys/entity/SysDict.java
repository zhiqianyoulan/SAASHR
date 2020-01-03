package com.cy.pj.sys.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * 字典信息实体类
 * @author wwj
 * @since: 11:16 2019/7/4
 */
@Data
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    //字典id，主键
    private Long dictId;

    //字典名称
    private String dictName;

    //字典编码
    private String dictCode;

    //所属父级
    private String parentCode;

    //优先级【排序】
    private Long priority;

    //备注说明
    private String remark;

    //树形数据层级关系
    private String depth;
}
