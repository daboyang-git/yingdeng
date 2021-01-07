package com.springcloud.backstage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.springcloud.backstage.pojo.Asset;
import com.springcloud.backstage.pojo.AssetJoinForegroundUserJoinEnterpriseCertif;
import com.springcloud.backstage.pojo.AssetManagementContract;
import com.springcloud.backstage.pojo.AssetRegisterCondition;
import com.springcloud.backstage.pojo.Borrower;
import com.springcloud.backstage.pojo.CheckResult;
import com.springcloud.backstage.pojo.EnterpriseCertif;
import com.springcloud.backstage.pojo.ForegroundUser;
import com.springcloud.backstage.pojo.LoanIssuingAgency;
import com.springcloud.backstage.pojo.TrustContract;

public interface AssetRegisterMapper {

	/**
	 * 三表关联 Asset  ForegroundUser  EnterpriseCertif 分页高级查询
	 * @param assetRegisterCondition
	 * @return
	 */
	List<AssetJoinForegroundUserJoinEnterpriseCertif> queryByPageAndCondition(
			AssetRegisterCondition assetRegisterCondition);

	/**
	 * 通过id查询一条资产登记信息
	 * @param assetId
	 * @return
	 */
	Asset queryAssetById(@Param("assetId")Integer assetId);

	/**
	 * 通过id查询一条前台用户信息
	 * @param userId
	 * @return
	 */
	ForegroundUser queryForegroundUserById(@Param("userId")Integer userId);

	/**
	 * 通过userId查询一条企业认证信息
	 * @param userId
	 * @return
	 */
	EnterpriseCertif queryEnterpriseCertifByUserId(@Param("userId")Integer userId);

	/**
	 * 通过id查询一条借款人表的信息
	 * @param borrowId
	 * @return
	 */
	Borrower queryBorrowerById(@Param("borrowId")Integer borrowId);

	/**
	 * 通过id查询一条贷款发放机构信息
	 * @param lenderId
	 * @return
	 */
	LoanIssuingAgency queryLoanIssuingAgencyById(@Param("lenderId")Integer lenderId);

	/**
	 * 通过id查询一条信托合同基本信息
	 * @param trustContractId
	 * @return
	 */
	TrustContract queryTrustContractById(@Param("trustContractId")Integer trustContractId);

	/**
	 * 通过id查询一条资产管理合同基本信息
	 * @param assetManagementContractId
	 * @return
	 */
	AssetManagementContract queryAssetManagementContractById(@Param("assetManagementContractId")Integer assetManagementContractId);

	/**
	 * 资产信息审核通过,通过id修改状态
	 * @param assetId
	 */
	void assetVerifySuccess(@Param("assetId")Integer assetId);

	/**
	 * 通过资产信息id查询一条核对结果
	 * @param assetId
	 * @return
	 */
	CheckResult selectByAssetId(@Param("assetId")Integer assetId);

	/**
	 * 根据资产信息的id添加一条成功核对结果
	 * @param assetId
	 */
	void insertByAssetId(@Param("assetId")Integer assetId);

	/**
	 * 根据资产信息的id修改一条成功核对结果
	 * @param assetId
	 */
	void updateByAssetId(@Param("assetId")Integer assetId);

	/**
	 * 资产信息审核拒绝,通过id修改状态
	 * @param assetId
	 */
	void assetVerifyFail(@Param("assetId")Integer assetId);

	/**
	 * 根据资产信息的id添加一条失败核对结果
	 * @param assetId
	 */
	void failToInsertByAssetId(@Param("assetId")Integer assetId,@Param("remark")String remark);

	/**
	 * 根据资产信息的id修改一条失败核对结果
	 * @param assetId
	 */
	void failToUpdateByAssetId(@Param("assetId")Integer assetId,@Param("remark")String remark);

}
