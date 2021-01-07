package com.springcloud.backstage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.backstage.dao.DataRegisterMapper;
import com.springcloud.backstage.pojo.DataRegisterCondition;
import com.springcloud.backstage.pojo.ForegroundUserJoinEnterpriseCertif;
import com.springcloud.backstage.service.IDataRegisterService;

@Service
public class DataRegisterServiceImpl implements IDataRegisterService {
	@Autowired
	private DataRegisterMapper dataRegisterMapper;

	@Override
	public PageInfo<ForegroundUserJoinEnterpriseCertif> queryByPageAndCondition(
			DataRegisterCondition dataRegisterCondition, Integer pageIndex) {
		PageHelper.startPage(pageIndex, 10);
		List<ForegroundUserJoinEnterpriseCertif> list = dataRegisterMapper.queryByPageAndCondition(dataRegisterCondition);
		return new PageInfo<>(list,10);
	}

	@Override
	public ForegroundUserJoinEnterpriseCertif queryByEnterpriseCertifId(Integer enterpriseCertifId) {
		return dataRegisterMapper.queryByEnterpriseCertifId(enterpriseCertifId);
	}

	@Override
	public void verifySuccess(Integer enterpriseCertifId) {
		dataRegisterMapper.verifySuccess(enterpriseCertifId);
	}

	@Override
	public void commitVerifyFail(Integer enterpriseCertifId, String verifyRemarks) {
		dataRegisterMapper.commitVerifyFail(enterpriseCertifId,verifyRemarks);
	}

}
