package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 借款人表的实体类
 * @author ChenHao
 *
 */
@Setter
@Getter
@ToString
public class Borrower implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	/**借款人表主键id*/
	private Integer id;
	/**组织机构代码,20个字符，任意字符，必填。若已办理三证合一，填写统一社会信用代码。*/
	private String organizationalCode; 
	/**借款人全称,30个字符，任意字符，必填。*/
	private String borrowerName;
	/**借款人简称,8个字符，任意字符，必填。*/
	private String borrowerAbbreviation;
	/**是否法人机构,下拉框选择，必填，可选择：是、否。*/
	private Integer isCorporation;
	/**机构注册地址,20个字符，任意字符，必填。*/
	private String RegisAddress;
	/**借款人所在地区,下拉框选择，必填。*/
	private String borrowerArea;
	/**借款人所属行业,下拉框选择，必填，按照国家统计局发布的GB/T 4754-2011《国民经济行业分类》填写*/
	private String industry;
	/**企业类型,下拉框选择，必填，可选择：大型企业、中型企业、小型企业、微型企业、个人。*/
	private Integer enterpriseType;
	/**主动创建时间*/
	private Date timeCreate;
	/**被动修改时间*/
	private Date timeModified;
	/**乐观锁版本号*/
	private Integer version;
	/**状态,软删除*/
	private Integer state;

}
