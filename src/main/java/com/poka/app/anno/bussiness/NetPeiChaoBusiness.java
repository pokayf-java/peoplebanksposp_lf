package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.MoneyOutService;
import com.poka.app.anno.enity.MoneyOut;
import com.poka.app.util.PokaDateUtil;

@Component
public class NetPeiChaoBusiness {
	Logger logger = Logger.getLogger(NetPeiChaoBusiness.class);
	
	private MoneyOutService moneyOutService;
	@Autowired
	@Qualifier("moneyOutService")
	public void setMoneyOutService(MoneyOutService moneyOutService) {
		this.moneyOutService = moneyOutService;
	}
	

	public boolean getMoneyOutInfo(List<MoneyOut> dataList) {
		Integer numSize = 0; 
		if (null != dataList && dataList.size() > 0) {
			for (MoneyOut moneyOut : dataList) {
				moneyOutService.save(moneyOut);
			}
			numSize = dataList.size();
		}
		logger.info("网点配钞数据同步成功...**[执行时间：" + PokaDateUtil.getNow() + "]**");
		logger.info("共计"+numSize +"条.");
		return true;
	}
	
}
