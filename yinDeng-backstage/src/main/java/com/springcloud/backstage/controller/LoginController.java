package com.springcloud.backstage.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录页面
 * @author ChenHao
 *
 */
@Controller
public class LoginController {
	
	/**
	 * 因为thymeleaf必须要转发才能访问html页面,此方法为后台登录首页
	 * @return
	 */
	@RequestMapping("")
	public String login() {
		return "login";
	}
	
	@RequestMapping("exit")
	public String exit(HttpSession session) {
		session.removeAttribute("backgroundUser");
		return "login";
	}
}
