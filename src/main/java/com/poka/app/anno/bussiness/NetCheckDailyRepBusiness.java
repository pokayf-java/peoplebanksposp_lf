package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.NetCheckDailyRepListService;
import com.poka.app.anno.base.service.impl.NetCheckDailyRepService;
import com.poka.app.anno.enity.NetCheckDailyRep;
import com.poka.app.util.PokaDateUtil;

@Component
public class NetCheckDailyRepBusiness {
	Logger logger = Logger.getLogger(NetCheckDailyRepBusiness.class);
	private NetCheckDailyRepService netCheckDailyRepService;
	private NetCheckDailyRepListService netCheckDailyRepListService;

	@Autowired
	@Qualifier("netCheckDailyRepListService")
	public void setNetCheckDailyRepListService(NetCheckDailyRepListService netCheckDailyRepListService) {
		this.netCheckDailyRepListService = netCheckDailyRepListService;
	}
	
	@Autowired
	@Qualifier("netCheckDailyRepService")
	public void setNetCheckDailyRepService(NetCheckDailyRepService netCheckDailyRepService) {
		this.netCheckDailyRepService = netCheckDailyRepService;
	}

	public boolean getNetCheckDailyRep(final List<NetCheckDailyRep> netListData) {
		
		String netNo = "";
		if (null != netListData && netListData.size() > 0) {
			for (NetCheckDailyRep netCheckDailyRep : netListData) {
				netNo = netCheckDailyRep.getNetNo();
				netCheckDailyRepService.save(netCheckDailyRep);
			}
		}
		logger.info("网点("+netNo+")日结数据同步成功...**"+PokaDateUtil.getNow()+"**");
		return true;
	}
}
