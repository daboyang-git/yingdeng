package com.springcloud.backstage.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页高级查询 BackgroundUser条件类
 * 
 * @author ChenHao
 *
 */
@Setter
@Getter
@ToString
public class BackgroundUserPageCondition extends Page<BackgroundUser> {

	private static final long serialVersionUID = 1L;
	/** 权限代码 */
	private Integer userPowerCode;
	/** 最小时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minTime;
	/** 最大时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date maxTime;
	/** 管理员姓名 */
	private String name;
	/** 最小的rownum值 */
	private Integer minRownum;
	/** 最大的rownum值 */
	private Integer maxRownum;

	public Integer getMinRownum() {
		return (getPageIndex() - 1) * getPageSize() + 1;
	}

	public Integer getMaxRownum() {
		return getPageIndex() * getPageSize();
	}
}
