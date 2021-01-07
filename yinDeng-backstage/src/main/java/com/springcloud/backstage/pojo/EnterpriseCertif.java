package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 企业认证表实体类
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class EnterpriseCertif implements Serializable {

	private static final long serialVersionUID = 1L;
	/**企业认证表主键*/
	private Integer id;
	/**统一社会信用代码*/
	private String creditCode;
	/**三证合一的营业执照电子档路径*/
	private String licenseImg;
	/**联系人*/
	private String contactPer;
	/**办公电话*/
	private String contactTel;
	/**单位地址*/
	private String address;
	/**机构简称*/
	private String shortName;
	/**机构性质*/
	private String instiNature;
	/**用户表主键*/
	private Integer userId;
	/**认证状态*/
	private Integer verifyState;
	/**机构全称*/
	private String fullName;
	/**认证备注*/
	private String verifyRemarks;
	/**提交时间*/
	private Date commitTime;
}
