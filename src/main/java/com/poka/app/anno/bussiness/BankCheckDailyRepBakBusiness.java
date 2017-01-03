package com.poka.app.anno.bussiness;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.BankCheckDailyRepBakService;
import com.poka.app.anno.base.service.impl.BankCheckDailyRepListService;
import com.poka.app.anno.enity.BankCheckDailyRepBak;
import com.poka.app.anno.enity.BankCheckDailyRepList;
import com.poka.app.util.ConstantUtil;
import com.poka.app.util.PokaDateUtil;

@Component
public class BankCheckDailyRepBakBusiness {
	Logger logger = Logger.getLogger(BankCheckDailyRepBakBusiness.class);
	private BankCheckDailyRepBakService bankCheckDailyRepBakService;
	private BankCheckDailyRepListService bankCheckDailyRepListService;

	@Autowired 
	@Qualifier("bankCheckDailyRepBakService")
	public void setBankCheckDailyRepService(BankCheckDailyRepBakService bankCheckDailyRepBakService) {
		this.bankCheckDailyRepBakService = bankCheckDailyRepBakService;
	}
	
	@Autowired 
	@Qualifier("bankCheckDailyRepListService")
	public void setBankCheckDailyRepListService(BankCheckDailyRepListService bankCheckDailyRepListService) {
		this.bankCheckDailyRepListService = bankCheckDailyRepListService;
	}
	
	
	public boolean getBankCheckDailyRepBak(List<BankCheckDailyRepBak> bankListData){
		if (ConstantUtil.bankAndNetRepFlag.trim().equals("Enabled")) {
			String bankNo = "";
			if(null!=bankListData&&bankListData.size()>0){
				for(BankCheckDailyRepBak bankCheckDailyRepBak:bankListData){
					bankNo = bankCheckDailyRepBak.getBankNo();
					bankCheckDailyRepBakService.save(bankCheckDailyRepBak);
				}
			}
			logger.info("银行("+bankNo+")日结数据同步成功...**"+PokaDateUtil.getNow()+"**");
			logger.info("共计"+bankListData.size()+"条.");
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean getBankCheckDailyRepList(final List<BankCheckDailyRepList> bankListData) {
		if (ConstantUtil.bankAndNetRepFlag.trim().equals("Enabled")) {
			String bankNo = "";
			if (null != bankListData && bankListData.size() > 0) {
				for (BankCheckDailyRepList bankCheckDailyRepListObj : bankListData) {
					bankNo = bankCheckDailyRepListObj.getBankNo();
					bankCheckDailyRepListService.save(bankCheckDailyRepListObj);
				}
			}
			logger.info("银行("+bankNo+")日结流水同步成功...**"+PokaDateUtil.getNow()+"**");
			logger.info("共计"+bankListData.size()+"条.");
			return true;
		} else {
			return false;
		}
		
	}
}
