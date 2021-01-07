package com.springcloud.circulation.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class User {
	private Integer id;
	private Integer userName;
	private Integer password;

}
