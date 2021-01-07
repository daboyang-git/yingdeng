package com.springcloud.backstage.service;

import java.util.Date;

import com.springcloud.backstage.pojo.BackgroundUser;
import com.springcloud.backstage.pojo.BackgroundUserPageCondition;

/**
 * 表backgroundUser的业务层
 * 
 * @author ChenHao
 *
 */
public interface IBackgroundUserService {
	/**
	 * 根据用户名和密码查询后台用户
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	BackgroundUser queryByUsernameAndPassword(String username, String password);

	/**
	 * 登录成功后,修改最后登录时间,最后登录地点ip,增加一次登录次数
	 * 
	 * @param loginCount
	 * @param lastLoginTime
	 * @param lastLoginIp
	 */
	void loginSuccessUpdateBgU(Integer loginCount, Date lastLoginTime, String lastLoginIp, Integer id);

	/**
	 * 根据一定的条件进行分页查询
	 * @return
	 */
	BackgroundUserPageCondition queryByPage(BackgroundUserPageCondition backgroundUserPageCondition);

	/**
	 * 通过Id查询信息
	 * @param id
	 * @return
	 */
	BackgroundUser queryById(Integer id);

	/**
	 * 修改管理员信息
	 * @param backgroundUser
	 */
	void updateBackgroundUser(BackgroundUser backgroundUser);

	/**
	 * 添加一条新的管理员
	 * @param backgroundUser
	 */
	void addBackgroundUser(BackgroundUser backgroundUser);

	/**
	 * 修改时判断用户名是否存在
	 * @param username
	 * @param lastUsername
	 * @return	true可以创建  false不能创建
	 */
	boolean verifyUsername(String username, String lastUsername);

	/**
	 * 添加时判断用户名是否存在
	 * @param username
	 * @return	true可以创建  false不能创建
	 */
	boolean addVerifyUsername(String username);

	/**
	 * 通过id软删除用户信息
	 * @param id
	 */
	void delBackgroundUser(Integer id);

	/**
	 * 通过id锁定用户
	 * @param id
	 */
	void lockBackgroundUser(Integer id);

	/**
	 * 通过id解锁用户
	 * @param id
	 */
	void unlockBackgroundUser(Integer id);
}
