package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.MonBoxAddMonService;
import com.poka.app.anno.enity.MonBoxAddMon;
import com.poka.app.util.PokaDateUtil;

/**
 * 
 * 将商行的钞箱加钞数据写入人行
 */
@Component
public class ChaoXJiaChaoBusiness {
	Logger logger = Logger.getLogger(ChaoXJiaChaoBusiness.class);
	
	private MonBoxAddMonService monBoxAddMonService;
	@Autowired
	@Qualifier("monBoxAddMonService")
	public void setMonBoxAddMonService(MonBoxAddMonService monBoxAddMonService) {
		this.monBoxAddMonService = monBoxAddMonService;
	}
	

	public boolean getMonBoxAddMonInfo(List<MonBoxAddMon> dataList) {
		Integer numSize = 0; 
		if (null != dataList && dataList.size() > 0) {
			for (MonBoxAddMon monBoxAddMon : dataList) {
				monBoxAddMonService.save(monBoxAddMon);
			}
			numSize = dataList.size();
		}
		logger.info("钞箱加钞数据同步成功...**[执行时间：" + PokaDateUtil.getNow() + "]**");
		logger.info("共计"+numSize +"条.");
		return true;
	}
	
}
