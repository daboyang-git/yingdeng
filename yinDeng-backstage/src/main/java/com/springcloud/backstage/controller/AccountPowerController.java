package com.springcloud.backstage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcloud.backstage.service.IAccountPowerService;

/**
 * accountPower类的web层
 * @author ChenHao
 *
 */
@Controller
@RequestMapping("accountPower")
public class AccountPowerController {
	@Autowired
	private IAccountPowerService accountPowerService;
	
	@RequestMapping("show")
	@ResponseBody
	public String show() {
		return accountPowerService.queryAll().toString();
	}
}
