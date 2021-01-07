package com.springcloud.backstage.dao;

import java.util.List;

import com.springcloud.backstage.pojo.AccountPower;

public interface AccountPowerMapper {
	/**
	 * 查询整个AccountPower表数据
	 * @return
	 */
	List<AccountPower> queryAll();
	
}
