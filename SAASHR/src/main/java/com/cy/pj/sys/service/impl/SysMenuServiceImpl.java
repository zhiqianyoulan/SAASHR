package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.Node;

import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		System.out.println("==========MenuServiceImpl==========");
		List<Map<String, Object>> list = sysMenuDao.findObjects();
		if (list.size() == 0 || list == null)
			throw new ServiceException("没有关联记录哦。。。");
		return list;
	}

	/** 删除菜单数据 */
	@Override
	public int deleteObject(Integer id) {
		/** 参数有效性检验 */
		if (id == null || id < 0)
			throw new IllegalArgumentException("请先选择！");
		/** 检查菜单下有没有子菜单 */
		int count = sysMenuDao.getChildCount(id);
		if (count > 0)
			throw new ServiceException("请先删除子菜单");
		/** 删除关系数据 */
		sysRoleMenuDao.deleteObjectsByMenuId(id);
		/** 删除自身信息并返回数据 */
		int row = sysMenuDao.deleteObject(id);
		if (row == 0)
			throw new ServiceException("此菜单可能已经不存在了哦");
		return row;
	}

	/** 查询菜单信息 */
	@Override
	public List<Node> findZtreeMenuNodes() {
		return sysMenuDao.findZtreeMenuNodes();
	}

	/** 菜单保存 */
	@Override
	public int saveObject(SysMenu entity) {
		// 1.合法验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		int rows;
		// 2.保存数据
		try {
			rows = sysMenuDao.insertObject(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		// 3.返回数据
		return rows;
	}

	/** 菜单修改更新 */
	@Override
	public int updateObject(SysMenu entity) {
		// 1.合法验证
		if (entity == null)
			throw new ServiceException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
		List<Node> findZtreeMenuNodes = sysMenuDao.findZtreeMenuNodes();
		for (Node node : findZtreeMenuNodes) {
			Integer parentIds = node.getParentId();
			Integer id = node.getId();
			if (entity.getParentId() == parentIds && parentIds != id)
				throw new ServiceException("你选择的上级菜单有误！！");
		}
		// 2.更新数据
		int rows = sysMenuDao.updateObject(entity);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		// 3.返回数据
		return rows;
	}

}
