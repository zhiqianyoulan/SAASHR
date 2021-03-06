package com.cy.pj.sys.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.TSysCode;

@Mapper
public interface TSysCodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_code
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_code
     *
     * @mbg.generated
     */
    int insert(TSysCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_code
     *
     * @mbg.generated
     */
    TSysCode selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_code
     *
     * @mbg.generated
     */
    List<TSysCode> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sys_code
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TSysCode record);
    
    List<TSysCode> selectCodeTreeByChildren(String parentCode);
}