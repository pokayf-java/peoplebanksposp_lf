package com.poka.app.anno.bussiness;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.SendFileService;
import com.poka.app.anno.enity.SendFile;
import com.poka.app.cb.ws.ICBPospSW;
import com.poka.app.util.CxfUtil;
import com.poka.app.util.PokaDateUtil;

@Component
public class SendFileBusiness {
	Logger logger = Logger.getLogger(SendFileBusiness.class);
	private SendFileService sendFileService;
	private CxfUtil cxfUtil;

	@Autowired
	public void setCxfUtil(CxfUtil cxfUtil) {
		this.cxfUtil = cxfUtil;
	}
	
	@Autowired 
	@Qualifier("sendFileService")
	public void setSendFileService(SendFileService sendFileService) {
		this.sendFileService = sendFileService;
	}
	
	/**
	 * 下发商行FSN文件记录
	 */
	public boolean sendFileData() {

		ICBPospSW service = cxfUtil.getCxfClient(ICBPospSW.class, cxfUtil.getClearingUrl());
		cxfUtil.recieveTimeOutWrapper(service);
		boolean result = Boolean.FALSE;
		List<SendFile> sendFileList = sendFileService.getSendFileList();
		if (null != sendFileList && sendFileList.size() > 0) {
			try {
				result = service.sendFileData(sendFileList);
			} catch (Exception ex) {
				logger.info("连接服务器失败...**"+PokaDateUtil.getNow()+"**");
				return false;
			}
			if (result) {
				logger.info("SendFile 数据同步成功...**"+PokaDateUtil.getNow()+"**");
				logger.info("共计" + sendFileList.size() + "条.");
			} else {
				logger.info("SendFile 数据同步失败...**"+PokaDateUtil.getNow()+"**");
				return false;
			}
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
