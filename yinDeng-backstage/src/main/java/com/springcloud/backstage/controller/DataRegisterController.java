package com.springcloud.backstage.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.springcloud.backstage.pojo.DataRegisterCondition;
import com.springcloud.backstage.pojo.ForegroundUserJoinEnterpriseCertif;
import com.springcloud.backstage.service.IDataRegisterService;
import com.springcloud.backstage.util.SendEmailUtils;

@Controller
@RequestMapping("dataRegister")
public class DataRegisterController {
	@Autowired
	private IDataRegisterService dataRegisterService;

	@RequestMapping("articleList")
	public String articleList(DataRegisterCondition dataRegisterCondition,
			@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, HttpServletRequest request) {
		request.setAttribute("dataRegisterCondition", dataRegisterCondition);

		PageInfo<ForegroundUserJoinEnterpriseCertif> pageInfoFJE = dataRegisterService
				.queryByPageAndCondition(dataRegisterCondition, pageIndex);

		request.setAttribute("pageInfoFJE", pageInfoFJE);

		return "article-list";
	}

	@RequestMapping("articleAdd")
	public String articleAdd(Integer enterpriseCertifId, HttpServletRequest request) {
		ForegroundUserJoinEnterpriseCertif foregroundUserJoinEnterpriseCertif = dataRegisterService
				.queryByEnterpriseCertifId(enterpriseCertifId);
		request.setAttribute("foregroundUserJoinEnterpriseCertif", foregroundUserJoinEnterpriseCertif);
		return "article-add";
	}

	@RequestMapping("verifySuccess")
	public String verifySuccess(Integer enterpriseCertifId) {
		dataRegisterService.verifySuccess(enterpriseCertifId);
		String email = dataRegisterService.queryByEnterpriseCertifId(enterpriseCertifId).getEmail();
		try {
			SendEmailUtils.sendEmail("资料信息审核提醒",
					"<h1 style='font-family:华文行楷;font-size:40px;text-decoration:none;'>您在银登中心的资料认证已经通过!</h1><br/><a style='font-size:30px;' href='http://localhost:8088/'>点此处跳转至银登网登录界面</a>",
					email);
		} catch (MessagingException e) {
			System.out.println("发送邮件出错!");
		}
		return "verifyCommit";
	}

	@RequestMapping("verifyFail")
	public String verifyFail(Integer enterpriseCertifId, HttpServletRequest request) {
		request.setAttribute("enterpriseCertifId", enterpriseCertifId);
		return "verifyFail";
	}

	@RequestMapping("commitVerifyFail")
	public String commitVerifyFail(Integer enterpriseCertifId, String verifyRemarks) {
		dataRegisterService.commitVerifyFail(enterpriseCertifId, verifyRemarks);
		String email = dataRegisterService.queryByEnterpriseCertifId(enterpriseCertifId).getEmail();
		try {
			SendEmailUtils.sendEmail("资料信息审核提醒",
					"<h1 style='font-family:华文行楷;font-size:40px;text-decoration:none;'>您在银登中心的资料认证审核未通过!</h1><br/>"
					+ "<h1 style='font-size:35px;text-decoration:none;color:red;'>原因:"+verifyRemarks+"</h1><br/><br/>"
					+ "<a style='font-size:30px;' href='http://localhost:8088/'>点此处跳转至银登网登录界面</a>",
					email);
		} catch (MessagingException e) {
			System.out.println("发送邮件出错!");
		}
		return "verifyCommit";
	}
}
