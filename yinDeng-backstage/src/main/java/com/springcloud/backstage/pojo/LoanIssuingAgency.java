package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 贷款发放机构信息表的实体类
 * @author ChenHao
 *
 */
@Setter
@Getter
@ToString
public class LoanIssuingAgency implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	
	/**贷款发放机构信息id*/
	private Integer id;
	/**贷款发放机构全称,30个字符，任意字符，必填，贷款实际发放机构，具体到分支行。	*/
	private String name;  //贷款发放机构全称
	/**贷款发放机构简称 10个字符，任意字符，必填。*/
	private String abbreviation; // 贷款发放机构简称
	/**贷款发放机构地区 下拉框选择，必填。*/
	private String area;  // 贷款发放机构地区
	/**贷款发放机构所属总行组织机构代码,20个字符,任意字符,必填,若已办理三证合一,填写统一社会信用代码。*/
	private String headOfficeOrganizationCode; //贷款发放机构所属总行组织机构代码
	/**资产初始持有人账号,客户端系统自动带出，通过哪个账号录入就显示哪个账号。*/
	private String initialAssetHolderAccount; // 资产初始持有人账号
	/**资产初始持有人全称 根据资产初始持有人账号自动带出。*/
	private String initialAssetHolderName;  //  资产初始持有人全称 
	/**资产初始持有人简称 根据资产初始持有人账号自动带出。*/
	private String initialAssetHolderAbbreviation;  // 资产初始持有人简称
	/**贷款管理人简称 10个字符，任意字符，手工录入“贷款管理人账号”后，系统自动带出“贷款管理人简称”。*/
	private String loanAdministratorAbbreviation; //贷款管理人简称
	/**主动创建时间*/
	private Date tmieCreate;   //主动创建时间
	/**被动修改时间*/
	private Date timeModified; //被动修改时间
	/**乐观锁版本号*/
	private Integer version;   //乐观锁版本号	
	/**状态,软删除*/
	private Integer state;     //状态
}
