package com.poka.app.cb.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.poka.app.anno.enity.BagInfo;
import com.poka.app.anno.enity.MonRule;
import com.poka.app.anno.enity.SendFile;
import com.poka.app.vo.AppointmenResult;

@WebService
public interface ICBPospSW {
	@WebMethod(operationName = "handleAppointmen")
	@WebResult(name = "result")
	public boolean handleAppointmen(@WebParam(name = "appointment") AppointmenResult appointment);

	@WebMethod(operationName = "sendMonRuleData")
	@WebResult(name = "result")
	public boolean sendMonRuleData(@WebParam(name = "monRuleList") List<MonRule> monRuleList);

	/*下发FSN文件记录*/
	@WebMethod(operationName = "sendFileData")
	@WebResult(name = "result")
	public boolean sendFileData(@WebParam(name = "sendFileList") List<SendFile> sendFileList);
	
	/*取款信息下发商行*/
	@WebMethod(operationName = "sendBagInfoData")
	@WebResult(name = "result")
	public boolean sendBagInfoData(@WebParam(name = "bagInfoList") List<BagInfo> bagInfoList);
	
}
