package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 表backgroundUser的实体类
 * 后台用户表
 * 
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class BackgroundUser implements Serializable {

	private static final long serialVersionUID = 1L;

	/**序列自动生成的id*/
	private Integer id;
	/**登录用户名*/
	private String username;
	/**登录密码,MD5加密*/
	private String password;
	/**手机号码*/
	private String phoneNumber;
	/**身份证号码*/
	private String IDCardNumber;
	/**姓名*/
	private String name;
	/**职位*/
	private String job;
	/**账户权限*/
	private Integer userPowerCode;
	/**创建时间*/
	private Date createTime;
	/**修改时间*/
	private Date updateTime;
	/**版本*/
	private Integer verssion;
	/**登录次数*/
	private Integer loginCount;
	/**上次登录时间*/
	private Date lastLoginTime;
	/**上次登录ip*/
	private String lastLoginIp;
	/**软删除状态*/
	private Integer state; 
	/**软删除状态:正常*/
	public static final Integer STATE_NORMAL = 0;
	/**软删除状态:停用*/
	public static final Integer STATE_LOCK = 1;
	/**软删除状态:删除*/
	public static final Integer STATE_DEL = -1;
}
