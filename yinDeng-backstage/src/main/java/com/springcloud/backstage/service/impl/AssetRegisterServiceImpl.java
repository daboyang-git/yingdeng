package com.springcloud.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.backstage.dao.AssetRegisterMapper;
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
import com.springcloud.backstage.service.IAssetRegisterService;

@Service
public class AssetRegisterServiceImpl implements IAssetRegisterService {
	@Autowired
	private AssetRegisterMapper assetRegisterMapper;

	@Override
	public PageInfo<AssetJoinForegroundUserJoinEnterpriseCertif> queryByPageAndCondition(
			AssetRegisterCondition assetRegisterCondition, Integer pageIndex) {
		PageHelper.startPage(pageIndex,10);
		List<AssetJoinForegroundUserJoinEnterpriseCertif> list = assetRegisterMapper.queryByPageAndCondition(assetRegisterCondition);
		return new PageInfo<>(list,10);
	}

	@Override
	public Asset queryAssetById(Integer assetId) {
		return assetRegisterMapper.queryAssetById(assetId);
	}

	@Override
	public ForegroundUser queryForegroundUserById(Integer userId) {
		return assetRegisterMapper.queryForegroundUserById(userId);
	}

	@Override
	public EnterpriseCertif queryEnterpriseCertifByUserId(Integer userId) {
		return assetRegisterMapper.queryEnterpriseCertifByUserId(userId);
	}

	@Override
	public Borrower queryBorrowerById(Integer borrowId) {
		return assetRegisterMapper.queryBorrowerById(borrowId);
	}

	@Override
	public LoanIssuingAgency queryLoanIssuingAgencyById(Integer lenderId) {
		return assetRegisterMapper.queryLoanIssuingAgencyById(lenderId);
	}

	@Override
	public TrustContract queryTrustContractById(Integer trustContractId) {
		return assetRegisterMapper.queryTrustContractById(trustContractId);
	}

	@Override
	public AssetManagementContract queryAssetManagementContractById(Integer assetManagementContractId) {
		return assetRegisterMapper.queryAssetManagementContractById(assetManagementContractId);
	}

	@Override
	public void assetVerifySuccess(Integer assetId) {
		assetRegisterMapper.assetVerifySuccess(assetId);
	}

	@Override
	public void updateOrInsertCheckResult(Integer assetId) {
		CheckResult checkResult = assetRegisterMapper.selectByAssetId(assetId);

		if (checkResult == null) {
			assetRegisterMapper.insertByAssetId(assetId);
		} else {
			assetRegisterMapper.updateByAssetId(assetId);
		}
	}

	@Override
	public void assetVerifyFail(Integer assetId) {
		assetRegisterMapper.assetVerifyFail(assetId);
	}

	@Override
	public void failToUpdateOrInsertCheckResult(Integer assetId,String remark) {
		CheckResult checkResult = assetRegisterMapper.selectByAssetId(assetId);
		
		if (checkResult == null) {
			assetRegisterMapper.failToInsertByAssetId(assetId,remark);
		} else {
			assetRegisterMapper.failToUpdateByAssetId(assetId,remark);
		}
	}
	
}
