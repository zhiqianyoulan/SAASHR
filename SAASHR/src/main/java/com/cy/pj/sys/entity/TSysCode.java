package com.cy.pj.sys.entity;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TSysCode implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.uuid
     *
     * @mbg.generated
     */
    private String uuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.code
     *
     * @mbg.generated
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.parentCode
     *
     * @mbg.generated
     */
    private String parentcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.level
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.isEnable
     *
     * @mbg.generated
     */
    private Integer isenable;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_code.orderId
     *
     * @mbg.generated
     */
    private Integer orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_sys_code
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    private List<TSysCode> children;
}