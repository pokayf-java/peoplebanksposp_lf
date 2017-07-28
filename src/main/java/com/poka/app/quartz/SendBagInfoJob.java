package com.poka.app.quartz;

import org.springframework.beans.factory.annotation.Autowired;

import com.poka.app.anno.bussiness.BagInfoBusiness;
import com.poka.app.util.ConstantUtil;

/**
 * 取款信息下发定时任务类
 * 
 * @author Administrator
 *
 */
public class SendBagInfoJob {

	BagInfoBusiness bagInfoBusiness;

	@Autowired
	public void setBagInfoBusiness(BagInfoBusiness bagInfoBusiness) {
		this.bagInfoBusiness = bagInfoBusiness;
	}

	public void work() {
		if (ConstantUtil.quKuanFlag.trim().equals("Enabled")) {
			bagInfoBusiness.sendBagInfoData();
		}
	}

}
