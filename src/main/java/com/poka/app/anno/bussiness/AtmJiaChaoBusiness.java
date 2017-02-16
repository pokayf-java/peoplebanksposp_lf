package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.BundleInfoService;
import com.poka.app.anno.enity.BundleInfo;
import com.poka.app.util.PokaDateUtil;

/**
 * 
 * 将商行的ATM加钞数据写入人行
 */
@Component
public class AtmJiaChaoBusiness {
	Logger logger = Logger.getLogger(AtmJiaChaoBusiness.class);
	
	private BundleInfoService bundleInfoService;
	@Autowired
	@Qualifier("bundleInfoService")
	public void setBundleInfoService(BundleInfoService bundleInfoService) {
		this.bundleInfoService = bundleInfoService;
	}
	

	public boolean getBundleInfo(List<BundleInfo> dataList) {
		Integer numSize = 0; 
		String bankNo = null;
		if (null != dataList && dataList.size() > 0) {
			for (BundleInfo bundleInfo : dataList) {
				bankNo = bundleInfo.getBankNo();
				bundleInfoService.save(bundleInfo);
			}
			numSize = dataList.size();
		}
		logger.info("[银行号：]["+bankNo+"] ATM加钞数据同步成功...**[执行时间：" + PokaDateUtil.getNow() + "]**");
		logger.info("共计"+numSize +"条.");
		return true;
	}
	
}
