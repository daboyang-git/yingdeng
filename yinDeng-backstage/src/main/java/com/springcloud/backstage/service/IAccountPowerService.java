package com.springcloud.backstage.service;

import java.util.List;

import com.springcloud.backstage.pojo.AccountPower;

/**
 * 表AccountPower的业务层
 * @author ChenHao
 *
 */
public interface IAccountPowerService {
	/**
	 * 查询整个AccountPower表数据
	 * 
	 * @return
	 */
	List<AccountPower> queryAll();
}
