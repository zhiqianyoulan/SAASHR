package com.cy.pj.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.pj.common.util.ShiroUtils;
import com.cy.pj.sys.service.SysUserService;
import com.cy.pj.sys.vo.SysUserMenuVo;

/*
 * 基于此Controller对象处理项目中的所有页面请求
 */
@RequestMapping("/")
@Controller
public class PageController {
	@Autowired
	private SysUserService sysUserService;
	
	/* 返回首页页面 */
	@RequestMapping("doIndexUI")
	public String doIndexUI(Model model) {
		String username = ShiroUtils.getUsername();
		model.addAttribute("username",username);
		
		List<SysUserMenuVo> userMenus = sysUserService.findUserMenus();
		System.out.println("userMenus="+userMenus);
		model.addAttribute("userMenus", userMenus);
		return "starter";
	}

	/* 返回日志列表页面 */
	@RequestMapping("log/log_list")
	public String doLogUI() {
		return "sys/log_list";
	}

	/* 返回分页页面 */
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}

	/* 菜单管理列表呈现 */
	
	/*
	 * @RequestMapping("menu/menu_list") 
	 * public String doMenuUI() { 
	 * return "sys/menu_list";
	 *  }
	 */
	 
	/**
	 * rest风格（软件架构风格）的url映射 其中： 1）{ }表示rest表达式
	 * 
	 * 
	 */
	
	  @RequestMapping("{module}/{moduleUI}")
	  public String doModuleUI(@PathVariable String moduleUI) { 
		  return "sys/" + moduleUI; 
		  }
	 
	  /**呈现登录页面*/
	@RequestMapping("doLoginUI")
	public String doLoginUI() {
		return "login";
	}
	
	
	@RequestMapping("emp/emp_on")
	public String empOn() {
		return "emp/emp_on";
	}
	
	@RequestMapping("emp/emp_leave")
	public String empLeave() {
		return "emp/emp_leave";
	}
	@RequestMapping("emp/emp_edit")
	public String empEdit() {
		return "emp/emp_edit";
	}
	@RequestMapping("emp/emp_modify")
	public String empModify() {
		return "emp/emp_modify";
	}
	@RequestMapping("emp/emp_doLeave")
	public String empDoLeave() {
		return "emp/emp_doLeave";
	}
	
	@RequestMapping("emp/empLeave_list")
	public String empLeave_list() {
		return "emp/empLeave_list";
	}
	
	@RequestMapping("emp/empSx_list")
	public String empSx_list() {
		return "emp/empSx_list";
	}
	
	@RequestMapping("emp/empSy_list")
	public String empSy_list() {
		return "emp/empSy_list";
	}
	
	@RequestMapping("emp/empJz_list")
	public String empJz_list() {
		return "emp/empJz_list";
	}
	
	
	
	
	
	
	
}
