package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.pj.sys.entity.SysLog;
/*DAO(数据访问对象)
 * 1)此对象的实例由mybatis框架创建
 * 2)此对象实例会自动注入SqlSessionFactory对象
 */
@Mapper
public interface SysLogDao {
	//按条件统计记录总数
	int getRowCount(@Param("username")String username);
	
	//查询当前页面记录数据
	/*基于条件username，从指定位置startIndex，查询pageSize*/
	List<SysLog> findPageObjects(
			@Param("username")String username,//查询条件（查询那个用户的日志信息）
			@Param("startIndex")Integer startIndex,//当前页面起始位置
			@Param("pageSize")Integer pageSize);//当前页 的页面大小
	
	//基于日志记录id执行删除操作
	int deleteObjects(@Param("ids")Integer... ids);
	
	/**新增用户日志信息*/
	int insertObject(SysLog entity);
}
