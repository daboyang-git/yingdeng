package com.yindeng.register.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产实体类
 * 
 * @author Administrator
 *
 */
public class Asset extends BaseEntity {

	private static final long serialVersionUID = 1L;

	// 资产代码
	private String assetCode;
	// 资产临时代码
	private String assetTempCode;
	// 资产全称
	private String assetName;
	// 资产简称,录入时不显示，完备性核对通过后系统自动生成
	private String assetAbbreviation;
	// 流转标的类型,下拉框选择，必填，可选择：债权、信托受益权、债权收益权、资管计划收益权。
	private Byte transfer;
	// 原始贷款合同编号,若发现录入的原始贷款合同编号及借据编号与已登记资产的相同，即重复录入，则合法性检查不通过
	private String originalLoanContractNumber;
	// 原始贷款借据编号,银行内部贷款借据号或借款凭证号
	private String originalLoanLendingNumber;
	// 资产类型,下拉框选择
	private String assetType;
	// 贷款用途
	private String loanPurpose;
	// 贷款五级分类,下拉框选择，可选择：正常、关注、次级、可疑、损失。
	private Byte loanClassification;
	// 币种,下拉框选择，可选择：CNY-人民币、USD-美元、HKD-港元、EUR-欧元、GBP-英镑、JPY-日元。
	private Byte currency;
	// 贷款余额（元）,贷款剩余本金额，支持2位小数
	private BigDecimal loanBalance;
	// 贷款余额大写,根据贷款余额（元）自动带出
	private String loanBalanceUpper;
	// 利率浮动方式,下拉框选择，可选择：固定利率、浮动利率（浮动点）、浮动利率（浮动比率）。
	private Byte interestRateFloatingMode;
	// 贷款利率（%）,100以内数字，支持6位小数，利率浮动方式选择固定利率时必填。
	private BigDecimal loanInterestRate;
	// 利率基准,下拉框选择，当利率浮动方式选择浮动（浮动点或浮动比率）时必填
	private BigDecimal interestRateBenchmark;
	// 利率浮动点（bp）,最长6位整数（正负均可），利率浮动方式选择浮动利率（浮动点）时必填。
	private BigDecimal interestRateFloatingPoint;
	// 100以内数字（正负均可），支持2位小数，利率浮动方式选择浮动利率（浮动比率）时必填。
	private BigDecimal floatingRateOfInterestRate;
	// 当前执行利率（%）,100以内数字，支持6位小数，当利率浮动方式选择浮动（浮动点或浮动比率）时必填。
	private BigDecimal currentExecutionRate;
	// 贷款起息日,下拉框选择，日期，必填
	private Date startingDateOfLoan;
	// 贷款到期日,下拉框选择，日期，必填，不得早于或等于贷款起息日。
	private Date maturityDateOfLoan;
	// 贷款期限,最长6位整数
	private Integer loanPeriod;
	// 贷款期限单位,下拉框选择，年、月、日，必填。
	private Byte termUnitOfLoan;
	// 贷款期限天数,不可填写，系统自动计算并显示，等于到期日减起息日
	private Integer daysOfLoanMaturity;
	// 贷款付息方式（个月/次）,8个字符，任意字符，必填。
	private String interestPaymentOnLoans;
	// 担保方式,采用横向复选框的点选方式，必填，可复选，类型有：无担保、保证、抵押、质押、其他。
	private Byte guaranteeMode;
	// 增信情况,160个字符,任意字符,必填。
	private String creditEnhancement;
	// 资产状态,由系统自动显示,不可录入,有已录入,待核对,已登记,已注销
	private Byte state;
	// 提交登记时间,从系统时间自动获得,不可录入
	private Date timeOfSubmissionOfRegistration;
	// 主动创建时间,不在页面显示
	private Date timeCreate;
	// 被动更新时间,不在页面显示
	private Date timeModified;
	// 乐观锁版本号
	private Byte version;
	// 登记金额,必填
	private BigDecimal regisAmount;
	// 借款人id
	private Integer borrowerId;
	// 贷款发放机构id
	private Integer lenderId;
	// 信托合同基本信息id
	private Integer trustContractId;
	// 资产管理合同表id
	private Integer assetManagementContractId;
	//用户账号
	private Integer userId;
}
