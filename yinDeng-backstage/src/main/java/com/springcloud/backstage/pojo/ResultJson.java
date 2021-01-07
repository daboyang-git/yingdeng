package com.springcloud.backstage.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 返回给前端的JSON信息
 * @author ChenHao
 *
 */
@Getter
@Setter
@ToString
public class ResultJson implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**成功或者失败*/
	private Boolean success;
	/**返回给前端的信息*/
	private String info;
}
