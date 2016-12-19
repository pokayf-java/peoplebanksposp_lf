package com.poka.app.quartz;

import org.springframework.beans.factory.annotation.Autowired;

import com.poka.app.anno.bussiness.SendFileBusiness;
import com.poka.app.util.ConstantUtil;

/**
 * 下发文件到商行定时任务类
 * @author lb
 * 
 */
public class SendFileJob {
	
	private SendFileBusiness sendFileBusiness;
	
	@Autowired
	public void setSendFileBusiness(SendFileBusiness sendFileBusiness) {
		this.sendFileBusiness = sendFileBusiness;
	}

	public void work() {
		
		if(ConstantUtil.sendFileFlag.equals("Enabled")){
			sendFileBusiness.sendFileData();
		}
	}
	
}
