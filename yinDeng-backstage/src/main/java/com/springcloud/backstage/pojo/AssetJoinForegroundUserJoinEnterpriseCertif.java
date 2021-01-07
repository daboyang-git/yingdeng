package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 三表关联 Asset  ForegroundUser  EnterpriseCertif 分页查询字段
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class AssetJoinForegroundUserJoinEnterpriseCertif implements Serializable {

	private static final long serialVersionUID = 1L;
	/**资产信息表*/
	/**作为主键,由序列生成*/
	private Integer assetId;
	/**资产代码,提交登记前不显示,不可录入,提交登记后，自动分配代码*/
	private String assetCode;  //资产代码
	/**资产临时代码,录入确认后即可产生*/
	private String assetTempCode;  //资产临时代码
	/**资产简称,录入时不显示，完备性核对通过后系统自动显示*/
	private String assetAbbreviation; //资产简称
	/**流转标的类型,下拉框选择，必填，可选择：债权、信托受益权、债权收益权、资管计划收益权。*/
	private Integer transfer; //流转标的类型
	/**资产类型,下拉框选择*/
	private String assetType;  // 资产类型
	/**提交登记时间,从系统时间自动获得,不可录入*/
	private Date timeOfSubmissionOfRegistration; //提交登记时间
	
	
	/**前台用户表*/
	/**前台用户表登录用户名*/
	private String loginName;
	
	/**资料认证表*/
	/**统一社会信用代码*/
	private String creditCode;
	/**单位地址*/
	private String address;
	/**机构简称*/
	private String shortName;
}
