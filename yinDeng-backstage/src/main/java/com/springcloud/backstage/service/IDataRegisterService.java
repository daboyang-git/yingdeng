package com.springcloud.backstage.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.backstage.pojo.DataRegisterCondition;
import com.springcloud.backstage.pojo.ForegroundUserJoinEnterpriseCertif;

/**
 * 对于资料登记模块的Service层
 * @author ChenHao
 *
 */
public interface IDataRegisterService {

	/**
	 * 分页高级表连接查询
	 * @param dataRegisterCondition
	 * @param pageIndex
	 * @return
	 */
	PageInfo<ForegroundUserJoinEnterpriseCertif> queryByPageAndCondition(DataRegisterCondition dataRegisterCondition,
			Integer pageIndex);

	/**
	 * 通过资料表的id表连接查询 ForegroundUserJoinEnterpriseCertif
	 * @param enterpriseCertifId
	 * @return
	 */
	ForegroundUserJoinEnterpriseCertif queryByEnterpriseCertifId(Integer enterpriseCertifId);

	/**
	 * 验证通过, 通过ID修改认证状态
	 * @param enterpriseCertifId
	 */
	void verifySuccess(Integer enterpriseCertifId);

	/**
	 * 审核拒绝,通过ID修改认证状态,和失败信息
	 * @param enterpriseCertifId
	 * @param verifyRemarks
	 */
	void commitVerifyFail(Integer enterpriseCertifId, String verifyRemarks);

}
