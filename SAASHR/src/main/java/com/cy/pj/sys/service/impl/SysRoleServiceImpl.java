package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.config.PageProperties;
import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.CheckBox;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;
import com.cy.pj.sys.vo.SysRoleMenuVo;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private PageProperties pageProperties;
	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		//1.对参数进行校验
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数并进行校验
		int rowCount=sysRoleDao.getRowCount(name);
		if(rowCount==0)
		throw new ServiceException("没有找到对应记录");
		//3.查询当前页记录
		int pageSize = pageProperties.getPageSize();
		int startIndex=(pageCurrent-1)*pageSize;
		int pageCount=((rowCount-1)/pageSize+1);//总页数
		List<SysRole> records=sysRoleDao.findPageObjects(name,startIndex, pageSize);
		//4.对查询结果进行封装并返回
		return new PageObject<>(records, rowCount, pageCurrent, pageSize);
	}
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao; 
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	@Override
	public int deleteObject(Integer id) {
		//1.参数校验
		if(id==null || id<=0)//参数校验时，==null要放到前面
			throw new IllegalArgumentException("请先选择！！！");
		//2.删除角色关系数据
		sysRoleMenuDao.deleteObjectsByRoleId(id);//删除角色菜单关系数据
		sysUserRoleDao.deleteObjectsByRoleId(id);//删除角色用户关系数据
		//3.删除自身信息并返回结果
		int rows = sysRoleDao.deleteObject(id);
		if(rows==0)
			throw new ServiceException("删除的数据不存在...");
		return rows;
	}
	
	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		//1.参数有效性检验
		if(entity==null)
			throw new IllegalArgumentException("保存的数据不能为空！！！");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("保存的角色名不能为空！！！");
		if(menuIds==null || menuIds.length==0)
			throw new ServiceException("必须为角色分配权限！！！");
		//2.保存角色自身信息
		int rows = sysRoleDao.insertObject(entity);
		//3.保存角色和菜单关系数据
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		//4.返回结果
		return rows;
	}

	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		//参数有效性检验
		if(id==null || id<=0)
			throw new IllegalArgumentException("您输入的id值不合法！！！");
		//
		SysRoleMenuVo result = sysRoleDao.findObjectById(id);
		//
		if(result==null)
			throw new ServiceException("此记录已不存在！！！");
		return result;
	}

	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		//1.参数验证
		if(entity==null)
			throw new ServiceException("更新对象内容不能为空！！");
		if(entity.getId()==null)
			throw new ServiceException("id值不能为空！！"); 
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("角色名不能为空！！");
		if(menuIds==null || menuIds.length==0)
			throw new ServiceException("必须为角色制定一个权限！！");
		//2.更新数据
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		System.out.println("id============="+entity.getId());
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		int rows = sysRoleDao.updateObject(entity);
		
		//3.返回结果
		return rows;
	}

	/**获取角色id，name属性*/
	@Override
	public List<CheckBox> findObjects() {
		List<CheckBox> rows = sysRoleDao.findObjects();
		return rows;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
