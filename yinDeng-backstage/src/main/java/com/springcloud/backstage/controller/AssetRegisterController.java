package com.springcloud.backstage.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
import com.springcloud.backstage.service.IAssetRegisterService;
import com.springcloud.backstage.util.SendEmailUtils;

@Controller
@RequestMapping("assetRegister")
public class AssetRegisterController {
	@Autowired
	private IAssetRegisterService asserRegisterService;

	@RequestMapping("assetRegisterList")
	public String assetRegisterList(AssetRegisterCondition assetRegisterCondition,
			@RequestParam(value = "pageIndex", defaultValue = "1") Integer pageIndex, HttpServletRequest request) {
		request.setAttribute("assetRegisterCondition", assetRegisterCondition);

		PageInfo<AssetJoinForegroundUserJoinEnterpriseCertif> pageInfoAFE = asserRegisterService
				.queryByPageAndCondition(assetRegisterCondition, pageIndex);

		request.setAttribute("pageInfoAFE", pageInfoAFE);

		return "assetRegister-list";
	}

	@RequestMapping("assetRegisterAdd")
	public String assetRegisterAdd(Integer assetId, HttpServletRequest request) {
		Asset asset = asserRegisterService.queryAssetById(assetId);
		request.setAttribute("asset", asset);

		Integer userId = asset.getUserId();
		ForegroundUser foregroundUser = asserRegisterService.queryForegroundUserById(userId);
		request.setAttribute("foregroundUser", foregroundUser);

		EnterpriseCertif enterpriseCertif = asserRegisterService.queryEnterpriseCertifByUserId(userId);
		request.setAttribute("enterpriseCertif", enterpriseCertif);

		Integer borrowId = asset.getBorrowerId();
		Borrower borrower = asserRegisterService.queryBorrowerById(borrowId);
		request.setAttribute("borrower", borrower);

		Integer lenderId = asset.getLenderId();
		LoanIssuingAgency loanIssuingAgency = asserRegisterService.queryLoanIssuingAgencyById(lenderId);
		request.setAttribute("loanIssuingAgency", loanIssuingAgency);

		Integer trustContractId = asset.getTrustContractId();
		if (trustContractId != null) {
			TrustContract trustContract = asserRegisterService.queryTrustContractById(trustContractId);
			request.setAttribute("trustContract", trustContract);
		}

		Integer assetManagementContractId = asset.getAssetManagementContractId();
		if (assetManagementContractId != null) {
			AssetManagementContract assetManagementContract = asserRegisterService
					.queryAssetManagementContractById(assetManagementContractId);
			request.setAttribute("assetManagementContract", assetManagementContract);
		}

		return "assetRegister-add";
	}

	@RequestMapping("assetVerifySuccess")
	public String assetVerifySuccess(Integer assetId, String email) {
		asserRegisterService.assetVerifySuccess(assetId);
		asserRegisterService.updateOrInsertCheckResult(assetId);
		
		try {
			SendEmailUtils.sendEmail("资产信息审核提醒",
					"<h1 style='font-family:华文行楷;font-size:40px;text-decoration:none;'>您在银登中心的资产信息登记已经通过!</h1><br/><a style='font-size:30px;' href='http://localhost:8088/'>点此处跳转至银登网登录界面</a>",
					email);
		} catch (MessagingException e) {
			System.out.println("发送邮件出错!");
		}
		return "verifyCommit";
	}

	@RequestMapping("assetVerifyFail")
	public String assetVerifyFail(Integer assetId, String email, HttpServletRequest request) {
		request.setAttribute("assetId", assetId);
		request.setAttribute("email", email);
		return "assetVerifyFail";
	}

	@RequestMapping("commitAssetVerifyFail")
	public String commitAssetVerifyFail(Integer assetId, String email, String remark) {
		asserRegisterService.assetVerifyFail(assetId);
		asserRegisterService.failToUpdateOrInsertCheckResult(assetId,remark);
		
		try {
			SendEmailUtils.sendEmail("资料信息审核提醒",
					"<h1 style='font-family:华文行楷;font-size:40px;text-decoration:none;'>您在银登中心的资料认证审核未通过!</h1><br/>"
					+ "<h1 style='font-size:35px;text-decoration:none;color:red;'>原因:"+remark+"</h1><br/><br/>"
					+ "<a style='font-size:30px;' href='http://localhost:8088/'>点此处跳转至银登网登录界面</a>",
					email);
		} catch (MessagingException e) {
			System.out.println("发送邮件出错!");
		}
		return "verifyCommit";
	}
}
