package com.yindeng.register.pojo;

import java.io.Serializable;

/**
 * 实体类的父类,都继承其id属性
 * @author Administrator
 *
 */
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
