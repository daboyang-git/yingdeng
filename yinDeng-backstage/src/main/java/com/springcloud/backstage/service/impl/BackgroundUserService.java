package com.springcloud.backstage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.backstage.dao.BackgroundUserMapper;
import com.springcloud.backstage.pojo.BackgroundUser;
import com.springcloud.backstage.pojo.BackgroundUserPageCondition;
import com.springcloud.backstage.service.IBackgroundUserService;

@Service
public class BackgroundUserService implements IBackgroundUserService {
	@Autowired
	private BackgroundUserMapper backgroundUserMapper;

	@Override
	public BackgroundUser queryByUsernameAndPassword(String username, String password) {
		return backgroundUserMapper.queryByUsernameAndPassword(username, password);
	}

	@Override
	public void loginSuccessUpdateBgU(Integer loginCount, Date lastLoginTime, String lastLoginIp, Integer id) {
		backgroundUserMapper.loginSuccessUpdateBgU(loginCount, lastLoginTime, lastLoginIp, id);
	}

	@Override
	public BackgroundUserPageCondition queryByPage(BackgroundUserPageCondition backgroundUserPageCondition) {
		List<BackgroundUser> pageDatas = backgroundUserMapper.queryByPageCondition(backgroundUserPageCondition);
		Integer pageCount = backgroundUserMapper.queryCountByPageCondition(backgroundUserPageCondition);
		backgroundUserPageCondition.setPageDatas(pageDatas);
		backgroundUserPageCondition.setPageCount(pageCount);
		return backgroundUserPageCondition;
	}

	@Override
	public BackgroundUser queryById(Integer id) {
		return backgroundUserMapper.queryById(id);
	}

	@Override
	public void updateBackgroundUser(BackgroundUser backgroundUser) {
		backgroundUserMapper.updateBackgroundUser(backgroundUser);
	}

	@Override
	public void addBackgroundUser(BackgroundUser backgroundUser) {
		backgroundUserMapper.addBackgroundUser(backgroundUser);
	}

	@Override
	public boolean verifyUsername(String username, String lastUsername) {
		BackgroundUser backgroundUser = backgroundUserMapper.verifyUsername(username, lastUsername);
		if (backgroundUser == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addVerifyUsername(String username) {
		BackgroundUser backgroundUser = backgroundUserMapper.addVerifyUsername(username);
		if (backgroundUser == null) {
			return true;
		}
		return false;
	}

	@Override
	public void delBackgroundUser(Integer id) {
		backgroundUserMapper.delBackgroundUser(id);
	}

	@Override
	public void lockBackgroundUser(Integer id) {
		backgroundUserMapper.lockBackgroundUser(id);	
	}

	@Override
	public void unlockBackgroundUser(Integer id) {
		backgroundUserMapper.unlockBackgroundUser(id);
	}

}
