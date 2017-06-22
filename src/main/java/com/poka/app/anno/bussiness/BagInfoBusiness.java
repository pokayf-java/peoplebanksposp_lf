package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.BagInfoService;
import com.poka.app.anno.base.service.impl.BankInfoService;
import com.poka.app.anno.enity.BagInfo;
import com.poka.app.anno.enity.BankInfo;
import com.poka.app.cb.ws.ICBPospSW;
import com.poka.app.util.ConstantUtil;
import com.poka.app.util.CxfUtil;
import com.poka.app.util.PokaDateUtil;

@Component
public class BagInfoBusiness {

	Logger logger = Logger.getLogger(BagInfoBusiness.class);
	private BagInfoService bagInfoService;
	private BankInfoService bankInfoService;

	@Autowired
	@Qualifier("bagInfoService")
	public void setBagInfoService(BagInfoService bagInfoService) {
		this.bagInfoService = bagInfoService;
	}

	@Autowired
	@Qualifier("bankInfoService")
	public void setBankInfoService(BankInfoService bankInfoService) {
		this.bankInfoService = bankInfoService;
	}

	private CxfUtil cxfUtil;

	@Autowired
	public void setCxfUtil(CxfUtil cxfUtil) {
		this.cxfUtil = cxfUtil;
	}
	
	public boolean updateBagInfo(List<BagInfo> bagInfoList) {
		if (ConstantUtil.bagInfoFlag.trim().equals("Enabled")) {
			int listSize = bagInfoList.size();
			if (listSize <= 0 || null == bagInfoList) {
				return false;
			} else {
				for (BagInfo bagInfo : bagInfoList) {
					bagInfo.setPutStatus("1");
					bagInfo.setWriteStatus("1");
					bagInfoService.save(bagInfo);
				}
			}
			logger.info("横向调拨数据同步成功...**" + PokaDateUtil.getNow() + "**");
			return true;
		} else {
			return false;
		}
	}

	/**
	 *
	 * 取款信息下发
	 ***
	 */
	public void sendBagInfoData() {
		List<BankInfo> bankInfoList = bankInfoService.getBankInfoList();
		if (bankInfoList.size() > 0) {
			for (int i = 0; i < bankInfoList.size(); i++) {
				BankInfo bankInfo = bankInfoList.get(i);
				String bankIp = bankInfo.getIpAddr();
				String bankNo = bankInfo.getBankNo();
				String tempPort = null;
				List<BagInfo> bagInfoList = bagInfoService.getBagInfoList(bankNo);
				if (null != bagInfoList && bagInfoList.size() > 0) {
					if (null != bankIp && !bankIp.equals("")) {
						if (null != bankInfo.getIpport() && !"".equals(bankInfo.getIpport().trim())) {
							tempPort = bankInfo.getIpport().trim();
						} else {
							tempPort = cxfUtil.getPort();
						}
						ICBPospSW service = cxfUtil.getCxfClient(ICBPospSW.class, cxfUtil.getUrl(bankIp, tempPort));
						cxfUtil.recieveTimeOutWrapper(service);
						boolean result = Boolean.FALSE;
						try {
							result = service.sendBagInfoData(bagInfoList);
						} catch (Exception ex) {
							logger.info("连接服务器失败!");
						}
						if (result) {
							logger.info("银行号:[" + bankNo + "]-->ip:[" + bankIp + "] 取款据同步成功");
							logger.info("总计:" + bagInfoList.size() + "条");
							for (BagInfo bagInfo : bagInfoList) {
								bagInfo.setWriteStatus("0");
								bagInfoService.save(bagInfo);
							}
						} else {
							logger.info("银行号:[" + bankNo + "]-->ip:[" + bankIp + "] 取款数据同步失败");
						}
						try {
							Thread.sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else {
					logger.info("银行号:[" + bankNo + "]-->ip:[" + bankIp + "] 无取款数据同步");
				}
			}
		}
	}
}
