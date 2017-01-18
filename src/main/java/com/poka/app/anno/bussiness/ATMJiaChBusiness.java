package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.MoneyOutService;
import com.poka.app.anno.enity.MoneyOut;

@Component
public class ATMJiaChBusiness {
	Logger logger = Logger.getLogger(ATMJiaChBusiness.class);
	
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
		logger.info("共计"+numSize +"条.");
		return true;
	}
	
}
