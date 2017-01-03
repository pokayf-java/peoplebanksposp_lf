package com.poka.app.anno.bussiness;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.BusinessListCoreService;
import com.poka.app.anno.base.service.impl.BusinessListDetailService;
import com.poka.app.anno.enity.BusinessListCore;
import com.poka.app.anno.enity.BusinessListDetail;
import com.poka.app.util.PokaDateUtil;

@Component
public class LanBiaoBusiness {
	Logger logger = Logger.getLogger(LanBiaoBusiness.class);
	private BusinessListCoreService businessListCoreService;
	private BusinessListDetailService businessListDetailService;
	@Autowired
	@Qualifier("businessListCoreService")
	public void setBusinessListCoreService(BusinessListCoreService businessListCoreService) {
		this.businessListCoreService = businessListCoreService;
	}
	
	@Autowired
	@Qualifier("businessListDetailService")
	public void setBusinessListDetailService(BusinessListDetailService businessListDetailService) {
		this.businessListDetailService = businessListDetailService;
	}

	public boolean getBusinessListCoreInfo(List<BusinessListCore> dataList) {
		String netNo = "";
		Integer numSize = 0; 
		if (null != dataList && dataList.size() > 0) {
			for (BusinessListCore businessListCore : dataList) {
				netNo = businessListCore.getNetNo();
				businessListCoreService.save(businessListCore);
			}
			numSize = dataList.size();
		}
		logger.info("网点("+netNo+")核心业务数据同步成功...**"+PokaDateUtil.getNow()+"**");
		logger.info("共计"+numSize +"条.");
		return true;
	}
	
	public boolean getBusinessListDetailInfo(List<BusinessListDetail> dataList) {
		Integer numSize = 0; 
		if (null != dataList && dataList.size() > 0) {
			for (BusinessListDetail businessListDetail: dataList) {
				businessListDetailService.save(businessListDetail);
			}
			numSize = dataList.size();
		}
		logger.info("核心业务信息券别明细同步成功...**"+PokaDateUtil.getNow()+"**");
		logger.info("共计"+numSize +"条.");
		return true;
	}
}
