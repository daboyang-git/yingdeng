package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 资产登记高级分页查询条件类
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class AssetRegisterCondition implements Serializable {

	private static final long serialVersionUID = 1L;

	/**资产代码,提交登记前不显示,不可录入,提交登记后，自动分配代码*/
	private String assetCode;  //资产代码
	/**资产临时代码,录入确认后即可产生*/
	private String assetTempCode;  //资产临时代码
	/**资产简称,录入时不显示，完备性核对通过后系统自动显示*/
	private String assetAbbreviation; //资产简称
	
	
	/**查询需要的最小提交登记时间范围*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date minTime;
	/**查询需要的最大提交登记时间范围*/
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date maxTime;
	
	
	/**前台用户表登录用户名*/
	private String loginName;
	
	
	/**机构简称*/
	private String shortName;
}
