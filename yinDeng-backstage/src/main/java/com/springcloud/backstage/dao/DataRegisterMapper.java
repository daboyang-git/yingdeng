package com.springcloud.backstage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springcloud.backstage.pojo.DataRegisterCondition;
import com.springcloud.backstage.pojo.ForegroundUserJoinEnterpriseCertif;

public interface DataRegisterMapper {

	/**
	 * 多条件表连接查询 ForegroundUserJoinEnterpriseCertif
	 * @param dataRegisterCondition
	 * @return
	 */
	List<ForegroundUserJoinEnterpriseCertif> queryByPageAndCondition(DataRegisterCondition dataRegisterCondition);

	/**
	 * 通过资料表的id表连接查询 ForegroundUserJoinEnterpriseCertif
	 * @param enterpriseCertifId
	 * @return
	 */
	ForegroundUserJoinEnterpriseCertif queryByEnterpriseCertifId(@Param("enterpriseCertifId")Integer enterpriseCertifId);

	/**
	 * 通过ID修改认证状态
	 * @param enterpriseCertifId
	 */
	void verifySuccess(@Param("enterpriseCertifId")Integer enterpriseCertifId);

	/**
	 * 审核失败,通过id修改认证状态和失败原因
	 * @param enterpriseCertifId
	 * @param verifyRemarks
	 */
	void commitVerifyFail(@Param("enterpriseCertifId")Integer enterpriseCertifId, @Param("verifyRemarks")String verifyRemarks);

}
