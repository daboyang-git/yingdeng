package com.springcloud.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.backstage.dao.AccountPowerMapper;
import com.springcloud.backstage.pojo.AccountPower;
import com.springcloud.backstage.service.IAccountPowerService;

@Service
public class AccountPowerServiceImpl implements IAccountPowerService {

	@Autowired
	private AccountPowerMapper accountPowerMapper;

	@Override
	public List<AccountPower> queryAll() {
		return accountPowerMapper.queryAll();
	}
	
	
}
