package com.cy.pj.sys.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.EmployeeInfoDao;
import com.cy.pj.sys.dao.EmployeeLeaveInfoDao;
import com.cy.pj.sys.entity.EmpInfo;
import com.cy.pj.sys.entity.EmpJobInfo;
import com.cy.pj.sys.entity.EmpLeaveInfo;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.EmployeeInfoService;
import com.cy.pj.sys.vo.EmpDetailInfo;
@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
	@Autowired
	private PageProperties pageProperties;
	@Autowired
	private EmployeeInfoDao employeeInfoDao;
	@Autowired
	private EmployeeLeaveInfoDao employeeLeaveInfoDao;
	
	
	@Cacheable(value = "empList")
	@Override
	public PageObject<Map<String, Object>> findEmpList(Integer stats, Integer userId,Integer pageCurrent) {
		if(stats==null || stats<0)
			throw new IllegalArgumentException("参数错误。。。");
		//1.验证参数合法性
		if(pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码值不正确!!!");	
		//2.基于参数名得到总记录数
		int rowCount = employeeInfoDao.getRowCount(stats,userId);
		if(rowCount == 0)
			throw new ServiceException("没有对应的记录!!!");
		
		//3.基于条件查询当前页记录
		int pageSize=pageProperties.getPageSize();
		//指定位置
		int startIndex=(pageCurrent-1)*pageSize;
		//得到当前页记录
		
		List<Map<String, Object>> records = employeeInfoDao.findEmpList(startIndex, pageSize, stats, userId);
		if(records==null || records.size()==0)
			throw new ServiceException("没有对应记录哦！");
		//4.封装查询结果
	PageObject<Map<String, Object>> po =  new PageObject<>(records, rowCount, pageCurrent, pageSize);
		return po;
	}
	
	
	@CacheEvict(value="empList",allEntries = true)
	/**添加员工数据*/
	@Override
	public int insertEmpInfo(EmpDetailInfo detail) {
		/**获取员工基本信息*/
		Integer infoId = detail.getInfoId();
		String empName = detail.getEmpName();
		String sex = detail.getSex();
		String empPhone = detail.getEmpPhone();
		String empCard = detail.getEmpCard();
		String empEducation = detail.getEmpEducation();
		String empBirthday = detail.getEmpBirthday();
		String empRegistered = detail.getEmpRegistered();
		String empEmail = detail.getEmpEmail();
		Integer empCmpId = detail.getEmpCmpId();
		/**获取员工职位信息*/
		Integer jobInfoId = detail.getJobInfoId();
		Integer empDeptId = detail.getEmpDeptId();
		String empJoinTime = detail.getEmpJoinTime();
		String empJobType = detail.getEmpJobType();
		Integer empStats = detail.getEmpStats();
		String empBankNo = detail.getEmpBankNo();
		String empBankName = detail.getEmpBankName();
		String empBankAddr = detail.getEmpBankAddr();
		/**添加员工基本信息*/
		EmpInfo empInfo = new EmpInfo(null, empName, empCmpId, empPhone, empCard, empEducation, empBirthday, empRegistered, empEmail, sex);
		int rows1 = employeeInfoDao.insertEmpInfo(empInfo);
		if(rows1==0)
			throw new ServiceException("基本信息添加失败");
		/**添加员工职位信息*/
		EmpJobInfo empJobInfo = new EmpJobInfo(jobInfoId, empInfo.getId(), empDeptId, empJoinTime, empJobType, empStats, empBankNo, empBankName, empBankAddr);
		int rows2 = employeeInfoDao.insertEmpJobInfo(empJobInfo);
		if(rows2==0)
			throw new ServiceException("职位信息添加失败");
		 		return rows1;
	}

	@CacheEvict(value="empList",allEntries = true)
	/**修改员工数据*/
	@Override
	public int updateEmpInfo(EmpDetailInfo detail) {
		/**获取员工基本信息*/
		Integer infoId = detail.getInfoId();
		String empName = detail.getEmpName();
		String sex = detail.getSex();
		String empPhone = detail.getEmpPhone();
		String empCard = detail.getEmpCard();
		String empEducation = detail.getEmpEducation();
		String empBirthday = detail.getEmpBirthday();
		String empRegistered = detail.getEmpRegistered();
		String empEmail = detail.getEmpEmail();
		Integer empCmpId = detail.getEmpCmpId();
		/**获取员工职位信息*/
		Integer empDeptId = detail.getEmpDeptId();
		String empJobType = detail.getEmpJobType();
		String empBankNo = detail.getEmpBankNo();
		String empBankName = detail.getEmpBankName();
		String empBankAddr = detail.getEmpBankAddr();
		
		EmpInfo updateInfo = new EmpInfo(infoId, empName, empCmpId, empPhone, empCard, empEducation, empBirthday, empRegistered, empEmail, sex);
		int row3 = employeeInfoDao.updataEmpInfo(updateInfo);
		if(row3==0)
			throw new ServiceException("修改员工基本信息失败");
		
		EmpJobInfo updateJobInfo = new EmpJobInfo(null,infoId, empDeptId,null,empJobType,null,empBankNo, empBankName, empBankAddr);
		int row4 = employeeInfoDao.updataEmpJobInfo(updateJobInfo);
		if(row4==0)
			throw new ServiceException("修改员工职位信息失败");
		return 0;
	}


	@CacheEvict(value="empList",allEntries = true)
	@Override
	public Map<String,Object> findEmpObject(Integer id) {
		return employeeInfoDao.findEmpObject(id);
	}


	/**
	 * 统计
	 */
	@Override
	public Map<String, Integer> getTotalCount(Integer userId) {
		List<Integer> gcet = employeeInfoDao.getCountEmployeeType(userId);
		List<Integer> gcs = employeeInfoDao.getCountSex(userId);
		int lctm = employeeLeaveInfoDao.leaveCountThisMonth(userId);
		Integer zaizhi = employeeInfoDao.getRowCount(0, userId);
		Integer shiyong = gcet.get(0);
		Integer shixi = gcet.get(1);
		Integer jianzhi = gcet.get(2);
		Integer male = gcs.get(0);
		Integer feMale = gcs.get(1);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("shiyong", shiyong);
		map.put("shixi", shixi);
		map.put("jianzhi", jianzhi);
		map.put("male", male);
		map.put("feMale", feMale);
		map.put("lctm", lctm);
		map.put("zaizhi", zaizhi);
		
		return map;
	}

	
	
	/**
	 * 为员工办理离职登记
	 */
	@CacheEvict(value="empList",allEntries = true)
	@Override
	public int updateEmpStats(EmpLeaveInfo entity) {
		if(StringUtils.isEmpty(entity.getEmployeeId()))
			throw new ServiceException("请选择需要办理离职的员工");
		if(StringUtils.isEmpty(entity.getLeaveType()))
			throw new ServiceException("请选择离职类型！");
		int rows = employeeInfoDao.insertLeaveInfo(entity);
		employeeInfoDao.updateStats(entity.getEmployeeId());
		return rows;
	}


	





}
