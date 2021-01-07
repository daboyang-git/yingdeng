package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 信托合同基本信息表的实体类
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class TrustContract implements Serializable {

	private static final long serialVersionUID = 1L;
	/**主键*/
	private Integer id;
	/**主动创建时间*/
	private Date timeCreate;
	/**被动修改时间*/
	private Date timeModified;
	/**乐观锁版本号*/
	private Integer version;
	/**信托合同名称 30个字符，任意字符，必填。*/
	private String trustContractName; 
	/**信托设立日 下拉框选择，日期。*/
	private Date trustEstablishmentDate;
	/**信托终止日 下拉框选择，日期，不早于或等于信托设立日*/
	private Date trustTerminationDate;
	/**信托受益权本金（元） 支持2位小数，必填。	*/
	private BigDecimal princOfTrustBeneRight;
	/**信托受益权本金大写（元） 根据信托受益权本金（元）自动带出。*/
	private String princOfTrustBeneRightUpper;
	/**信托预期收益率（%） 100以内数字，支持小数点后6位，必填。*/
	private BigDecimal expectedReturnRateOfTrust;
	/**委托人 30个字符，任意字符，必填。*/
	private String trustContractClient;
	/**受托人 30个字符，任意字符，必填。*/
	private String trustee;
	/**受益人 30个字符，任意字符，必填。*/
	private String trustContractBeneficiary;
	/**状态,软删除*/
	private Integer state;
}
