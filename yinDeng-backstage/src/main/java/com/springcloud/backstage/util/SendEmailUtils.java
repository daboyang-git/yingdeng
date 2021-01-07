package com.springcloud.backstage.util;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.util.MailSSLSocketFactory;

/**
	<dependencies>
		<dependency>
			<groupId>javax.mail</groupId>
			<artifactId>javax.mail-api</artifactId>
			<version>1.5.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.sun.mail/javax.mail -->
		<dependency>
			<groupId>com.sun.mail</groupId>
			<artifactId>javax.mail</artifactId>
			<version>1.5.4</version>
		</dependency>

	</dependencies>
 * maven添加版本必须一致,否则可能会报错
 * 
 * @author ChenHao
 *
 */
public class SendEmailUtils {
	// 用于读取配置文件
	private static Properties props = null;
	private static MailSSLSocketFactory msf = null;
	private static Session session = null;
	private static Message message = null;
	// 此类的功能是发送邮件 又会话获得实例
	private static Transport transport = null;

	static {
		// 用于读取配置文件
		props = new Properties();

		// 开启Debug调试

		props.setProperty("mail.debug", "true");

		// 发送服务器需要身份验证

		props.setProperty("mail3.chinabond.com.cn", "true");

		// 发送邮件服务器的主机名

		props.setProperty("mail.host", "mail3.chinabond.com.cn");

		// 发送邮件协议

		props.setProperty("mail.transport.protocol", "smtp");

		// 开启ssl加密（并不是所有的邮箱服务器都需要，但是qq邮箱服务器是必须的）

		try {
			msf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}

		msf.setTrustAllHosts(true);

		props.put("mail.smtp.ssl.enable", "true");

		props.put("mail.smtp.ssl.socketFactory", msf);

		// 获取Session会话实例（javamail
		// Session与HttpSession的区别是Javamail的Session只是配置信息的集合）

		session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				// 用户名密码验证（取得的授权吗）

				return new PasswordAuthentication("yindengzhongxin@foxmail.com",
						"kyasniknrknjgagh");

			}

		});
		// 抽象类MimeMessage为实现类 消息载体封装了邮件的所有消息

		message = new MimeMessage(session);

		// 此类的功能是发送邮件 又会话获得实例

		try {
			transport = session.getTransport();
			// 开启连接
			transport.connect();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		
	}

	/**
	 * 发送邮件
	 * 
	 * @param subject
	 *            邮件标题
	 * @param content
	 *            邮件内容,可以为html标签,会解析
	 * @param email
	 *            收件方电子邮箱
	 * @throws MessagingException
	 */
	public static void sendEmail(String subject, String content, String email)
			throws MessagingException {

		// 设置邮件主题
		message.setSubject(subject);

		// 封装需要发送电子邮件的信息
		message.setContent(content, "text/html;charset=utf-8");
		/* message.setText("<a href='http://www.yindeng.com.cn/'></a>"); */

		// 设置发件人地址

		message.setFrom(new InternetAddress("yangyang@chinabond.com.cn"));

		// 设置收件人地址邮件信息

		transport.sendMessage(message, new Address[] { new InternetAddress(
				email) });

		// 邮件发送后关闭信息
		// 单例模式,连接不能关闭
		/*transport.close();*/

	}

}