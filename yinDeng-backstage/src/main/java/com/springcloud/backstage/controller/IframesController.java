package com.springcloud.backstage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springcloud.backstage.pojo.BackgroundUser;
import com.springcloud.backstage.pojo.BackgroundUserPageCondition;
import com.springcloud.backstage.service.IAccountPowerService;
import com.springcloud.backstage.service.IBackgroundUserService;

/**
 * 用于内联框架的转发的Controller层
 * @author ChenHao
 *
 */
@Controller
@RequestMapping("iframes")
public class IframesController {
	@Autowired
	private IAccountPowerService accountPowerService;
	@Autowired
	private IBackgroundUserService backgroundUserService;
	/**
	 * 欢迎页面
	 * @return
	 */
	@RequestMapping("welcome")
	public String welcome() {
		return "welcome";
	}
	
	/**
	 * 查看角色
	 * @param request
	 * @return
	 */
	@RequestMapping("adminRole")
	public String adminRole(HttpServletRequest request) {
		request.getSession().setAttribute("accountPowers", accountPowerService.queryAll());
		return "admin-role";
	}
	
	/**
	 * 管理员列表
	 * @return
	 */
	@RequestMapping("adminList")
	public String adminList(HttpServletRequest request,BackgroundUserPageCondition backgroundUserPageCondition) {
		request.getSession().setAttribute("accountPowers", accountPowerService.queryAll());
		BackgroundUserPageCondition condition = backgroundUserService.queryByPage(backgroundUserPageCondition);
		request.getSession().setAttribute("backgroundUserPageCondition", condition);
		
		Integer startPage = 1;
		Integer endPage = condition.getPageTotal();
		
		if(condition.getPageTotal() > 10) {
			startPage = condition.getPageIndex() - 5;
			endPage = condition.getPageIndex() + 4;
			if (startPage < 1) {
				startPage = 1;
				endPage = startPage + 9;
			}
			
			if (endPage > condition.getPageTotal()) {
				startPage = condition.getPageTotal() - 9;
				endPage = condition.getPageTotal();
			}
		}
		
		List<Integer> pageIndexList = new ArrayList<>();
		
		for (int i = startPage; i <= endPage; i++) {
			pageIndexList.add(i);
		}
		
		request.getSession().setAttribute("pageIndexList",pageIndexList);
		
		return "admin-list";
	}
	
	/**
	 * 修改管理员信息
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("adminUpdate")
	public String adminUpdate(HttpServletRequest request,Integer id) {
		BackgroundUser queryById = backgroundUserService.queryById(id);
		request.setAttribute("queryById", queryById);
		request.getSession().setAttribute("lastUsername", queryById.getUsername());
		return "admin-update";
	}
	
	/**
	 * 添加一条管理员
	 * @return
	 */
	@RequestMapping("adminAdd")
	public String adminAdd() {
		return "admin-add";
	}
	
}
