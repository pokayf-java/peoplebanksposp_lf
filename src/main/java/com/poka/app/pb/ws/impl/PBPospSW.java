package com.poka.app.pb.ws.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.poka.app.anno.bussiness.AppointmentBusiness;
import com.poka.app.anno.bussiness.AtmJiaChaoBusiness;
import com.poka.app.anno.bussiness.BagInfoBusiness;
import com.poka.app.anno.bussiness.BankCheckDailyRepBakBusiness;
import com.poka.app.anno.bussiness.BankCheckDailyRepBusiness;
import com.poka.app.anno.bussiness.CIBAgencyBusiness;
import com.poka.app.anno.bussiness.ChaoXJiaChaoBusiness;
import com.poka.app.anno.bussiness.LanBiaoBusiness;
import com.poka.app.anno.bussiness.NetCheckDailyRepBakBusiness;
import com.poka.app.anno.bussiness.NetCheckDailyRepBusiness;
import com.poka.app.anno.bussiness.NetPeiChaoBusiness;
import com.poka.app.anno.bussiness.PaymentBusiness;
import com.poka.app.anno.bussiness.PerInfoAndBranchBusiness;
import com.poka.app.anno.bussiness.QryApplyBusiness;
import com.poka.app.anno.bussiness.ZhengkunqkBusiness;
import com.poka.app.anno.enity.BagInfo;
import com.poka.app.anno.enity.BankCheckDailyRepBak;
import com.poka.app.anno.enity.BankCheckDailyRepList;
import com.poka.app.anno.enity.BundleInfo;
import com.poka.app.anno.enity.BusinessListCore;
import com.poka.app.anno.enity.BusinessListDetail;
import com.poka.app.anno.enity.MonBoxAddMon;
import com.poka.app.anno.enity.MoneyOut;
import com.poka.app.anno.enity.NetCheckDailyRepBak;
import com.poka.app.anno.enity.NetCheckDailyRepList;
import com.poka.app.anno.enity.QryApply;
import com.poka.app.anno.enity.WithDrawInfo;
import com.poka.app.pb.ws.IPBPospSW;
import com.poka.app.vo.AppointmentVo;
import com.poka.app.vo.PaymentVo;
import com.poka.app.vo.TAgencyCheck;

@WebService(endpointInterface = "com.poka.app.pb.ws.IPBPospSW")
public class PBPospSW implements IPBPospSW {

	private AppointmentBusiness appointmentBussiness;
	private PaymentBusiness paymentBussiness;
	private QryApplyBusiness qryApplyBussiness;
	private PerInfoAndBranchBusiness perInfoAndBranchBussiness;
	private BankCheckDailyRepBusiness bankCheckDailyRepBussiness;
	private BankCheckDailyRepBakBusiness bankCheckDailyRepBakBussiness;
	private NetCheckDailyRepBusiness netCheckDailyRepBussiness;
	private NetCheckDailyRepBakBusiness netCheckDailyRepBakBussiness;
	private BagInfoBusiness bagInfoBusiness; 
	private LanBiaoBusiness lanBiaoBusiness;
	private NetPeiChaoBusiness netPeiChaoBusiness;
	private AtmJiaChaoBusiness atmJiaChaoBusiness;
	private ChaoXJiaChaoBusiness chaoXJiaChaoBusiness;
	private ZhengkunqkBusiness zhengkunqkBusiness;
	private CIBAgencyBusiness cibAgencyBusiness;
	
	
	@Autowired
	public void setCibAgencyBusiness(CIBAgencyBusiness cibAgencyBusiness) {
		this.cibAgencyBusiness = cibAgencyBusiness;
	}

	@Autowired
	public void setZhengkunqkBusiness(ZhengkunqkBusiness zhengkunqkBusiness) {
		this.zhengkunqkBusiness = zhengkunqkBusiness;
	}
	
	@Autowired
	public void setAtmJiaChaoBusiness(AtmJiaChaoBusiness atmJiaChaoBusiness) {
		this.atmJiaChaoBusiness = atmJiaChaoBusiness;
	}
	
	@Autowired
	public void setChaoXJiaChaoBusiness(ChaoXJiaChaoBusiness chaoXJiaChaoBusiness) {
		this.chaoXJiaChaoBusiness = chaoXJiaChaoBusiness;
	}
	
	@Autowired
	public void setBankCheckDailyRepBakBussiness(BankCheckDailyRepBakBusiness bankCheckDailyRepBakBussiness) {
		this.bankCheckDailyRepBakBussiness = bankCheckDailyRepBakBussiness;
	}
	
	@Autowired
	public void setNetPeiChaoBusiness(NetPeiChaoBusiness netPeiChaoBusiness) {
		this.netPeiChaoBusiness = netPeiChaoBusiness;
	}
	
	@Autowired
	public void setLanBiaoBusiness(LanBiaoBusiness lanBiaoBusiness) {
		this.lanBiaoBusiness = lanBiaoBusiness;
	}
	
	@Autowired
	public void setBagInfoBusiness(BagInfoBusiness bagInfoBusiness) {
		this.bagInfoBusiness = bagInfoBusiness;
	}

	
	@Autowired
	public void setNetCheckDailyRepBakBussiness(NetCheckDailyRepBakBusiness netCheckDailyRepBakBussiness) {
		this.netCheckDailyRepBakBussiness = netCheckDailyRepBakBussiness;
	}
	
	@Autowired
	public void setBankCheckDailyRepBussiness(BankCheckDailyRepBusiness bankCheckDailyRepBussiness) {
		this.bankCheckDailyRepBussiness = bankCheckDailyRepBussiness;
	}
	
	
	@Autowired
	public void setNetCheckDailyRepBussiness(NetCheckDailyRepBusiness netCheckDailyRepBussiness) {
		this.netCheckDailyRepBussiness = netCheckDailyRepBussiness;
	}
	
	@Autowired
	public void setPerInfoAndBranchBussiness(PerInfoAndBranchBusiness perInfoAndBranchBussiness) {
		this.perInfoAndBranchBussiness = perInfoAndBranchBussiness;
	}

	@Autowired
	public void setPaymentBussiness(PaymentBusiness paymentBussiness) {
		this.paymentBussiness = paymentBussiness;
	}

	@Autowired
	public void setQryApplyBussiness(QryApplyBusiness qryApplyBussiness) {
		this.qryApplyBussiness = qryApplyBussiness;
	}

	@Autowired
	public void setAppointmentBussiness(AppointmentBusiness appointmentBussiness) {
		this.appointmentBussiness = appointmentBussiness;
	}

	/**
	 * 兴业银行代理取款
	 * 2017年9月19日
	 */
	@Override
	public boolean agencyCheck(List<TAgencyCheck> checks) {
		return cibAgencyBusiness.agencyCheck(checks);
	}
	
	/*
	 * 预约请求处理
	 * 
	 * @see com.poka.app.pb.ws.IPBPospSW#makeAppointmen(com.poka.app.vo.
	 * AppointmentVo)
	 */
	@Override
	public boolean makeAppointmen(AppointmentVo appointment) {
		
		return appointmentBussiness.makeAppointment(appointment);
	}

	/*
	 * 交款处理
	 * 
	 * @see com.poka.app.pb.ws.IPBPospSW#makePayment(com.poka.app.vo.PaymentVo)
	 */
	@Override
	public boolean makePayment(PaymentVo payment) {
		return paymentBussiness.makePayment(payment);
	}

	@Override
	public boolean makeQryApply(QryApply qryApply) {
		return qryApplyBussiness.makeQryApply(qryApply);
	}

	@Override
	public boolean getPerInfoData(String listData) {
		return perInfoAndBranchBussiness.updatePerInfo(listData);
	}

	@Override
	public boolean getBanchInfoData(String listData) {
		return perInfoAndBranchBussiness.updateBranchInfo(listData);
	}

	@Override
	public boolean sendBankCheckDailyRepBak(List<BankCheckDailyRepBak> bankListData) {
		// TODO Auto-generated method stub
		return bankCheckDailyRepBakBussiness.getBankCheckDailyRepBak(bankListData);
	}

	@Override
	public boolean sendNetCheckDailyRepBak(List<NetCheckDailyRepBak> netCheckDailyRepList) {
		// TODO Auto-generated method stub
		return netCheckDailyRepBakBussiness.getNetCheckDailyRepBak(netCheckDailyRepList);
	}


	@Override
	public boolean sendBagInfo(List<BagInfo> bagInfoList) {
		// TODO Auto-generated method stub
		return bagInfoBusiness.updateBagInfo(bagInfoList);
	}

	@Override
	public boolean sendNetCheckDailyRepList(List<NetCheckDailyRepList> netCheckDailyRepListFlow) {
		// TODO Auto-generated method stub
		return netCheckDailyRepBakBussiness.getNetCheckDailyRepList(netCheckDailyRepListFlow);
	}

	@Override
	public boolean sendBankCheckDailyRepList(List<BankCheckDailyRepList> bankCheckDailyRepListFlow) {
		// TODO Auto-generated method stub
		return bankCheckDailyRepBakBussiness.getBankCheckDailyRepList(bankCheckDailyRepListFlow);
	}

	@Override
	public boolean sendBusinessListCoreInfo(List<BusinessListCore> businessListCoreList) {
		// TODO Auto-generated method stub
		return lanBiaoBusiness.getBusinessListCoreInfo(businessListCoreList);
	}

	@Override
	public boolean sendBusinessListDetailInfo(List<BusinessListDetail> businessListDetailList) {
		// TODO Auto-generated method stub
		return lanBiaoBusiness.getBusinessListDetailInfo(businessListDetailList);
	}

	@Override
	public boolean sendMoneyOutInfo(List<MoneyOut> sendMoneyOutInfoList) {
		return netPeiChaoBusiness.getMoneyOutInfo(sendMoneyOutInfoList);
	}
	@Override
	public boolean sendMonBoxAddMonInfo(List<MonBoxAddMon> sendMonBoxAddMonInfoList) {
		// TODO Auto-generated method stub
		return chaoXJiaChaoBusiness.getMonBoxAddMonInfo(sendMonBoxAddMonInfoList);
	}
	@Override
	public boolean sendBundleInfo(List<BundleInfo> sendBundleInfoList) {
		// TODO Auto-generated method stub
		return atmJiaChaoBusiness.getBundleInfo(sendBundleInfoList);
	}

	@Override
	public boolean sendWithDrawInfoInfo(List<WithDrawInfo> sendWithDrawInfoList) {
		// TODO Auto-generated method stub
		return zhengkunqkBusiness.getWithDrawInfo(sendWithDrawInfoList);
	}

}
