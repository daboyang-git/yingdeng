package com.springcloud.backstage.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 前台用户表实体类
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class ForegroundUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String loginName;
	
	private String loginPwd;
	
	private String contactPhone;
	
	private String email;
}
