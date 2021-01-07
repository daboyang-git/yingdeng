package com.springcloud.backstage.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springcloud.backstage.pojo.BackgroundUser;
import com.springcloud.backstage.pojo.ResultJson;
import com.springcloud.backstage.service.IBackgroundUserService;
import com.springcloud.backstage.util.MD5;
import com.springcloud.backstage.util.MustLogin;

/**
 * backgroundUser类的web层
 * @author ChenHao
 *
 */
@Controller
@RequestMapping("backgroundUser")
public class BackgroundUserController {
	@Autowired
	private IBackgroundUserService backgroundUserService;

	@RequestMapping("loginVerify")
	@ResponseBody
	public ResultJson loginVerify(HttpServletRequest request, String username, String password) {
		ResultJson resultJson = new ResultJson();
		BackgroundUser backgroundUser = backgroundUserService.queryByUsernameAndPassword(username,
				MD5.encode(password));
		if (backgroundUser == null) {
			resultJson.setSuccess(false);
			resultJson.setInfo("用户名或密码错误!");
		} else if(backgroundUser.getState() == BackgroundUser.STATE_DEL) {
			resultJson.setSuccess(false);
			resultJson.setInfo("该用户已删除,请联系管理员!");
		} else if(backgroundUser.getState() == BackgroundUser.STATE_LOCK) {
			resultJson.setSuccess(false);
			resultJson.setInfo("该用户已停用,请联系管理员!");
		} else {
			resultJson.setSuccess(true);
			backgroundUser.setLoginCount(backgroundUser.getLoginCount() + 1);
			request.getSession().setAttribute("backgroundUser", backgroundUser);
		}
		return resultJson;
	}

	@RequestMapping("loginSuccess")
	@MustLogin
	public String loginSuccess(HttpServletRequest request) {
		if(request.getSession().getAttribute("backgroundUser") == null) {
			return "login";
		}
		Integer loginCount = ((BackgroundUser)request.getSession().getAttribute("backgroundUser")).getLoginCount();
		Integer id = ((BackgroundUser)request.getSession().getAttribute("backgroundUser")).getId();
		backgroundUserService.loginSuccessUpdateBgU(loginCount,new Date(),request.getLocalAddr(),id);
		return "index";
	}
	
	@RequestMapping("updateBackgroundUser")
	public String updateBackgroundUser(BackgroundUser backgroundUser) {
		backgroundUser.setPassword(MD5.encode(backgroundUser.getPassword()));
		backgroundUserService.updateBackgroundUser(backgroundUser);
		
		return "updateSuccess";
	}
	
	@RequestMapping("addBackgroundUser")
	public String addBackgroundUser(BackgroundUser backgroundUser) {
		backgroundUser.setPassword(MD5.encode(backgroundUser.getPassword()));
		backgroundUserService.addBackgroundUser(backgroundUser);
		return "addSuccess";
	}
	
	@RequestMapping("verifyUsername")
	@ResponseBody
	public ResultJson verifyUsername(String username,HttpServletRequest request) {
		ResultJson resultJson = new ResultJson();
		String lastUsername = (String)request.getSession().getAttribute("lastUsername");
		boolean flag = backgroundUserService.verifyUsername(username,lastUsername);
		resultJson.setSuccess(flag);
		return resultJson;
	}
	@RequestMapping("addVerifyUsername")
	@ResponseBody
	public ResultJson addVerifyUsername(String username) {
		ResultJson resultJson = new ResultJson();
		boolean flag = backgroundUserService.addVerifyUsername(username);
		resultJson.setSuccess(flag);
		return resultJson;
	}
	
	@RequestMapping("delBackgroundUser")
	@ResponseBody
	public boolean delBackgroundUser(Integer id) {
		backgroundUserService.delBackgroundUser(id);
		return true;
	}
	
	@RequestMapping("lockBackgroundUser")
	@ResponseBody
	public boolean lockBackgroundUser(Integer id) {
		backgroundUserService.lockBackgroundUser(id);
		return true;
	}
	
	@RequestMapping("unlockBackgroundUser")
	@ResponseBody
	public boolean unlockBackgroundUser(Integer id) {
		backgroundUserService.unlockBackgroundUser(id);
		return true;
	}
	
}
