package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 资产信息表
 * @author ChenHao
 *
 */
@Setter
@Getter
@ToString
public class Asset implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	/**作为主键,由序列生成*/
	private Integer id;
	/**资产代码,提交登记前不显示,不可录入,提交登记后，自动分配代码*/
	private String assetCode;  //资产代码
	/**资产临时代码,录入确认后即可产生*/
	private String assetTempCode;  //资产临时代码
	/**资产全称,录入时不显示，完备性核对通过后系统自动生成*/
	private String assetName;  //资产全称
	/**资产简称,录入时不显示，完备性核对通过后系统自动显示*/
	private String assetAbbreviation; //资产简称
	/**流转标的类型,下拉框选择，必填，可选择：债权、信托受益权、债权收益权、资管计划收益权。*/
	private Integer transfer; //流转标的类型
	/**原始贷款合同编号,若发现录入的原始贷款合同编号及借据编号与已登记资产的相同，即重复录入，则合法性检查不通过	*/
	private String originalLoanContractNumber; //原始贷款合同编号
	/**原始贷款借据编号,银行内部贷款借据号或借款凭证号	*/
	private String originalLoanLendingNumber; //原始贷款借据编号
	/**资产类型,下拉框选择*/
	private String assetType;  // 资产类型
	/**贷款用途*/
	private String loanPurpose;  // 贷款用途
	/**贷款五级分类,下拉框选择，可选择：正常、关注、次级、可疑、损失。*/
	private Integer loanClassification;  // 贷款五级分类
	/**币种,下拉框选择，可选择：CNY-人民币、USD-美元、HKD-港元、EUR-欧元、GBP-英镑、JPY-日元*/
	private Integer currency;  //  币种
	/**贷款余额（元）,贷款剩余本金额，支持2位小数*/
	private Integer loanBalance;  //  贷款余额
	/**贷款余额大写,根据贷款余额（元）自动带出*/
	private String loanBalanceUpper;  // 贷款余额大写
	/**利率浮动方式,下拉框选择，可选择：固定利率、浮动利率（浮动点）、浮动利率（浮动比率）。*/
	private String interestRateFloatingMode;  // 利率浮动方式
	/**贷款利率（%）,100以内数字，支持6位小数，利率浮动方式选择固定利率时必填。	*/
	private Integer loanInterestRate;  //  贷款利率（%）
	/**利率基准,下拉框选择，当利率浮动方式选择浮动（浮动点或浮动比率）时必填*/
	private Integer interestRateBenchmark;  // 利率浮动点（bp）
	/**利率浮动点（bp）,最长6位整数（正负均可），利率浮动方式选择浮动利率（浮动点）时必填。*/
	private BigDecimal interestRateFloatingPoint;
	/**100以内数字（正负均可），支持2位小数，利率浮动方式选择浮动利率（浮动比率）时必填。*/
	private BigDecimal floatingRateOfInterestRate; //100以内数字（正负均可） 利率浮动方式选择浮动利率（浮动比率）时必填。
	/**当前执行利率（%）,100以内数字，支持6位小数，当利率浮动方式选择浮动（浮动点或浮动比率）时必填。*/
	private BigDecimal currentExecutionRate; //当前执行利率（%）
	/**贷款起息日,下拉框选择，日期，必填	*/
	private Date startingDateOfLoan; // 贷款起息日
	/**贷款到期日,下拉框选择，日期，必填，不得早于或等于贷款起息日。*/
	private Date maturityDateOfLoan; // 贷款到期日
	/**贷款期限,最长6位整数*/
	private Integer loanPeriod;      // 贷款期限
	/**贷款期限单位,下拉框选择，年、月、日，必填。*/
	private Integer termUnitOfLoan;  // 贷款期限单位
	/**贷款期限天数,不可填写，系统自动计算并显示，等于到期日减起息日*/
	private Integer daysOfLoanMaturity; // 贷款期限天数
	/**贷款付息方式（个月/次）,8个字符，任意字符，必填。*/
	private String interestPaymentOnLoans;  // 贷款付息方式
	/**担保方式,采用横向复选框的点选方式，必填，可复选，类型有：无担保、保证、抵押、质押、其他。*/
	private Integer guaranteeMode;  // 担保方式
	/**增信情况,160个字符,任意字符,必填。*/
	private String creditEnhancement;  // 增信情况
	/**资产状态,由系统自动显示,不可录入,有已录入1,待核对3,已登记2,已注销	*/
	private Integer state;  // 资产状态
	/**提交登记时间,从系统时间自动获得,不可录入*/
	private Date timeOfSubmissionOfRegistration; //提交登记时间
	/**主动创建时间,不在页面显示*/
	private Date timeCreate; // 主动创建时间
	/**被动更新时间,不在页面显示*/
	private Date timeModified;  // 被动更新时间
	/**乐观锁版本号*/
	private Integer version;  // 乐观锁版本号
	/**登记金额,必填*/
	private BigDecimal regisAmount;  // 登记金额
	/**借款人id*/
	private Integer borrowerId;  // 借款人
	/**贷款发放机构id*/
	private Integer lenderId;  //  贷款发放机构
	/**信托合同基本信息id*/
	private Integer trustContractId;  // 信托合同基本信息id	
	/**资产管理合同表id*/
	private Integer assetManagementContractId;  // 资产管理合同表id
	/**关联的用户id*/
	private Integer userId;  // 用户id
}
