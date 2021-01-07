package com.springcloud.backstage.util;

import java.util.UUID;

import javax.mail.MessagingException;

/**
 * 
 * java发送邮件测试
 */

public class TestMail {

	/*
	 * public static void main(String[] args) throws MessagingException,
	 * InterruptedException { SendEmailUtils.sendEmail("资料信息审核提醒",
	 * "<a style='font-size:40px;color:blue;text-decoration:none;' href='http://app.tanwan.com/htmlcode/17443.html'>您在银登中心认证的资产已经通过!</a><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='http://app.tanwan.com/htmlcode/17443.html' style='color:red;font-size:20px;'>邀请码:"
	 * + UUID.randomUUID() + "</a>", "824556144@qq.com"); }
	 */
	public static void main(String[] args) throws MessagingException, InterruptedException {
		SendEmailUtils.sendEmail("资料信息审核提醒",
				"<h1 style='font-family:华文行楷;font-size:40px;text-decoration:none;'>您在银登中心认证的资产已经通过!</h1><br/><a style='font-size:30px;' href='http://localhost:8088/'>点此处跳转至银登网登录界面</a>",
				"824556144@qq.com");
	}
}