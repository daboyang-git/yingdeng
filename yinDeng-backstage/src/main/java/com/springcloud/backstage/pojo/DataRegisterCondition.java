package com.springcloud.backstage.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 资料登记条件类
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class DataRegisterCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	/**最小提交时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minTime;
	/**最大提交时间*/
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxTime;
	/**登录用户名*/
	private String loginName;
	
}
