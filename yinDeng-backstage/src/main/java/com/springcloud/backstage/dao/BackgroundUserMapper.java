package com.springcloud.backstage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springcloud.backstage.pojo.BackgroundUser;
import com.springcloud.backstage.pojo.BackgroundUserPageCondition;

public interface BackgroundUserMapper {

	/**
	 * 根据用户名和密码查询用户信息
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	BackgroundUser queryByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

	/**
	 * 登录成功后,修改最后登录时间,最后登录地点ip,增加一次登录次数
	 * 
	 * @param loginCount
	 * @param lastLoginTime
	 * @param lastLoginIp
	 */
	void loginSuccessUpdateBgU(@Param("loginCount") Integer loginCount, @Param("lastLoginTime") Date lastLoginTime,
			@Param("lastLoginIp") String lastLoginIp, @Param("id") Integer id);


	/**
	 * 根据条件获取一个BackgroundUser的集合
	 * @param backgroundUserPageCondition
	 * @return
	 */
	List<BackgroundUser> queryByPageCondition(BackgroundUserPageCondition backgroundUserPageCondition);

	/**
	 * 根据条件获取符合该条件的总记录数
	 * @param backgroundUserPageCondition
	 * @return
	 */
	Integer queryCountByPageCondition(BackgroundUserPageCondition backgroundUserPageCondition);

	/**
	 * 通过Id查询一条信息
	 * @param id
	 * @return
	 */
	BackgroundUser queryById(@Param("id")Integer id);

	/**
	 * 通过id修改管理员信息
	 * @param backgroundUser
	 */
	void updateBackgroundUser(BackgroundUser backgroundUser);
	
	/**
	 * 添加一条管理员信息
	 * @param backgroundUser
	 */
	void addBackgroundUser(BackgroundUser backgroundUser);

	/**
	 * 修改时判断用户名是否存在
	 * @param username
	 * @param lastUsername
	 * @return
	 */
	BackgroundUser verifyUsername(@Param("username")String username, @Param("lastUsername")String lastUsername);

	/**
	 * 添加时判断用户名是否存在
	 * @param username
	 * @return
	 */
	BackgroundUser addVerifyUsername(@Param("username")String username);

	/**
	 * 通过id软删除管理员信息
	 * @param id
	 */
	void delBackgroundUser(@Param("id")Integer id);

	/**
	 * 通过id锁定管理员信息
	 * @param id
	 */
	void lockBackgroundUser(@Param("id")Integer id);

	/**
	 * 通过id解锁用户
	 * @param id
	 */
	void unlockBackgroundUser(@Param("id")Integer id);
}
