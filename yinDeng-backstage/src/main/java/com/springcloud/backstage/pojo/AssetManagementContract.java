package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 资产管理合同基本信息表的实体类
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class AssetManagementContract implements Serializable  {

	private static final long serialVersionUID = 1L;
	/**主键*/
	private Integer id;
	/**主动创建时间*/
	private Date timeCreate;
	/**被动修改时间*/
	private Date timeModified;
	/**状态,软删除*/
	private Integer state;
	/**资产管理合同名称 30个字符，任意字符，必填。*/
	private String assetManagementContractName;
	/**资管计划起息日 下拉框选择，日期，必填。*/
	private Date startingDate;
	/**资管计划到期日 下拉框选择，日期，不早于或等于资管计划起息日，必填。*/
	private Date maturityDate;
	/**资管计划本金（元） 支持2位小数，必填。*/
	private BigDecimal capitalOfManagementPlan;
	/**资管计划本金大写（元） 根据资管计划本金（元）自动带出*/
	private String capitalOfManagementPlanUpper;
	/**资管计划预期收益率（%） 100以内数字，支持小数点后6位，必填。*/
	private BigDecimal expectedReturnRateOfManagePlan;
	/**委托人 30个字符，任意字符，必填。*/
	private String client;
	/**资产管理人 30个字符，任意字符，必填。*/
	private String assetManager;
	/**受益人 30个字符，任意字符，必填。*/
	private String beneficiary;
	/**乐观锁版本号*/
	private Integer version;
}
