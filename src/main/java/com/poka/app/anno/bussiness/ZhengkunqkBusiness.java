package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.WithDrawInfoService;
import com.poka.app.anno.enity.WithDrawInfo;
import com.poka.app.util.PokaDateUtil;

/**
 * 
 * 将商行整捆取款数据写入人行
 */
@Component
public class ZhengkunqkBusiness {
	Logger logger = Logger.getLogger(ZhengkunqkBusiness.class);
	
	private WithDrawInfoService withDrawInfoService;
	
	@Autowired
	@Qualifier("withDrawInfoService")
	public void setWithDrawInfoService(WithDrawInfoService withDrawInfoService) {
		this.withDrawInfoService = withDrawInfoService;
	}
	

	public boolean getWithDrawInfo(List<WithDrawInfo> dataList) {
		Integer numSize = 0; 
		String bankNo = null;
		if (null != dataList && dataList.size() > 0) {
			for (WithDrawInfo withDrawInfo : dataList) {
				bankNo = withDrawInfo.getBankNo();
				withDrawInfoService.save(withDrawInfo);
			}
			numSize = dataList.size();
		}
		logger.info("[银行号：]["+bankNo+"] 整捆取款数据同步成功...**[执行时间：" + PokaDateUtil.getNow() + "]**");
		logger.info("共计["+numSize +"]条.");
		return true;
	}
	
}
