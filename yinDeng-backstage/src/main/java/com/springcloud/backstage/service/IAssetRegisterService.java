package com.springcloud.backstage.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.backstage.pojo.Asset;
import com.springcloud.backstage.pojo.AssetJoinForegroundUserJoinEnterpriseCertif;
import com.springcloud.backstage.pojo.AssetManagementContract;
import com.springcloud.backstage.pojo.AssetRegisterCondition;
import com.springcloud.backstage.pojo.Borrower;
import com.springcloud.backstage.pojo.EnterpriseCertif;
import com.springcloud.backstage.pojo.ForegroundUser;
import com.springcloud.backstage.pojo.LoanIssuingAgency;
import com.springcloud.backstage.pojo.TrustContract;

public interface IAssetRegisterService {

	/**
	 * 三表关联 Asset ForegroundUser EnterpriseCertif 分页高级查询
	 * 
	 * @param assetRegisterCondition
	 * @param pageIndex
	 * @return
	 */
	PageInfo<AssetJoinForegroundUserJoinEnterpriseCertif> queryByPageAndCondition(
			AssetRegisterCondition assetRegisterCondition, Integer pageIndex);

	/**
	 * 通过id查询一条资产登记信息
	 * 
	 * @param assetId
	 * @return
	 */
	Asset queryAssetById(Integer assetId);

	/**
	 * 通过id查询一条前台用户信息
	 * 
	 * @param userId
	 * @return
	 */
	ForegroundUser queryForegroundUserById(Integer userId);

	/**
	 * 通过userId查询一条企业认证信息
	 * 
	 * @param userId
	 * @return
	 */
	EnterpriseCertif queryEnterpriseCertifByUserId(Integer userId);

	/**
	 * 通过id查询一条借款人信息
	 * 
	 * @param borrowId
	 * @return
	 */
	Borrower queryBorrowerById(Integer borrowId);

	/**
	 * 通过id查询一条贷款发放机构信息
	 * @param lenderId
	 * @return
	 */
	LoanIssuingAgency queryLoanIssuingAgencyById(Integer lenderId);

	/**
	 * 通过id查询一条信托合同基本信息
	 * @param trustContractId
	 * @return
	 */
	TrustContract queryTrustContractById(Integer trustContractId);

	/**
	 * 通过id查询一条资产管理合同基本信息
	 * @param assetManagementContractId
	 * @return
	 */
	AssetManagementContract queryAssetManagementContractById(Integer assetManagementContractId);

	/**
	 * 资产信息审核通过,通过id修改状态
	 * @param assetId
	 */
	void assetVerifySuccess(Integer assetId);

	/**
	 * 资产信息审核通过,查询核对结果表,如果审核信息存在,修改审核状态,如果审核信息不存在,添加一条信息
	 * @param assetId
	 */
	void updateOrInsertCheckResult(Integer assetId);

	/**
	 * 资产信息审核拒绝,通过id修改状态
	 * @param assetId
	 */
	void assetVerifyFail(Integer assetId);

	/**
	 * 资产信息审核拒绝,查询核对结果表,如果审核信息存在,修改审核状态,如果审核信息不存在,添加一条信息
	 * @param assetId
	 */
	void failToUpdateOrInsertCheckResult(Integer assetId,String remark);


}
