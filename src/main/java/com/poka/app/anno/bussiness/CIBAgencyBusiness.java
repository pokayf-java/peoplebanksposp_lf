package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.BagInfoService;
import com.poka.app.util.PokaDateUtil;
import com.poka.app.vo.TAgencyCheck;

@Component
public class CIBAgencyBusiness {
	Logger logger = Logger.getLogger(CIBAgencyBusiness.class);
	private BagInfoService bagInfoService;

	@Autowired
	@Qualifier("bagInfoService")
	public void setBagInfoService(BagInfoService bagInfoService) {
		this.bagInfoService = bagInfoService;
	}

	public boolean agencyCheck(List<TAgencyCheck> checks) {
		logger.info("正在处理兴业银行代理取款下发...**"+PokaDateUtil.getNow()+"**");
		return bagInfoService.dealChecks(checks);
	}
}
