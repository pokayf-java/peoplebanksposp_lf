package com.poka.app.pb.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

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
import com.poka.app.vo.AppointmentVo;
import com.poka.app.vo.PaymentVo;

@WebService
public interface IPBPospSW {

	@WebMethod(operationName = "makeAppointmen")
	@WebResult(name = "result")
	public boolean makeAppointmen(@WebParam(name = "appointment") AppointmentVo appointment);

	@WebMethod(operationName = "makePayment")
	@WebResult(name = "result")
	public boolean makePayment(@WebParam(name = "payment") PaymentVo payment);

	@WebMethod(operationName = "makeQryApply")
	@WebResult(name = "result")
	public boolean makeQryApply(@WebParam(name = "qryApply") QryApply qryApply);

	@WebMethod(operationName = "getPerInfoData")
	@WebResult(name = "result")
	public boolean getPerInfoData(@WebParam(name = "listData") String listData);

	@WebMethod(operationName = "getBanchInfoData")
	@WebResult(name = "result")
	public boolean getBanchInfoData(@WebParam(name = "listData") String listData);

	@WebMethod(operationName = "sendNetCheckDailyRep")
	@WebResult(name = "result")
	public boolean sendNetCheckDailyRepBak(
			@WebParam(name = "netCheckDailyRepList") List<NetCheckDailyRepBak> netCheckDailyRepList);

	@WebMethod(operationName = "sendNetCheckDailyRepList")
	@WebResult(name = "result")
	public boolean sendNetCheckDailyRepList(
			@WebParam(name = "netCheckDailyRepListFlow") List<NetCheckDailyRepList> netCheckDailyRepListFlow);

	@WebMethod(operationName = "sendBankCheckDailyRep")
	@WebResult(name = "result")
	public boolean sendBankCheckDailyRepBak(
			@WebParam(name = "bankCheckDailyRepList") List<BankCheckDailyRepBak> bankCheckDailyRepList);

	@WebMethod(operationName = "sendBankCheckDailyRepList")
	@WebResult(name = "result")
	public boolean sendBankCheckDailyRepList(
			@WebParam(name = "bankCheckDailyRepListFlow") List<BankCheckDailyRepList> bankCheckDailyRepListFlow);

	/* 横向调拨 */
	@WebMethod(operationName = "sendBagInfo")
	@WebResult(name = "result")
	public boolean sendBagInfo(@WebParam(name = "bagInfoList") List<BagInfo> bagInfoList);

	/* 核心业务流水 */
	@WebMethod(operationName = "sendBusinessListCoreInfo")
	@WebResult(name = "result")
	public boolean sendBusinessListCoreInfo(
			@WebParam(name = "businessListCoreList") List<BusinessListCore> businessListCoreList);

	/* 核心业务信息券别明细 */
	@WebMethod(operationName = "sendBusinessListDetailInfo")
	@WebResult(name = "result")
	public boolean sendBusinessListDetailInfo(
			@WebParam(name = "businessListDetailList") List<BusinessListDetail> businessListDetailList);

	/* 网点配钞 */
	@WebMethod(operationName = "sendMoneyOutInfo")
	@WebResult(name = "result")
	public boolean sendMoneyOutInfo(@WebParam(name = "sendMoneyOutInfoList") List<MoneyOut> sendMoneyOutInfoList);
	
	/* 钞箱加钞 */
	@WebMethod(operationName = "sendMonBoxAddMonInfo")
	@WebResult(name = "result")
	public boolean sendMonBoxAddMonInfo(@WebParam(name = "sendMonBoxAddMonInfoList") List<MonBoxAddMon> sendMonBoxAddMonInfoList);
	
	/* ATM加钞  */
	@WebMethod(operationName = "sendBundleInfo")
	@WebResult(name = "result")
	public boolean sendBundleInfo(@WebParam(name = "sendBundleInfoList") List<BundleInfo> sendBundleInfoList);

}
