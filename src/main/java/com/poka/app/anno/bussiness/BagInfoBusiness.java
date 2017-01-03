package com.poka.app.anno.bussiness;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.poka.app.anno.base.service.impl.BagInfoService;
import com.poka.app.anno.enity.BagInfo;
import com.poka.app.util.ConstantUtil;
import com.poka.app.util.PokaDateUtil;

@Component
public class BagInfoBusiness {
	
	Logger logger = Logger.getLogger(BagInfoBusiness.class);
	private BagInfoService bagInfoService;
	
	@Autowired 
	@Qualifier("bagInfoService")
	public void setBagInfoService(BagInfoService bagInfoService) {
		this.bagInfoService = bagInfoService;
	}

	public boolean updateBagInfo(List<BagInfo> bagInfoList) {
		if (ConstantUtil.bagInfoFlag.trim().equals("Enabled")) {
			int listSize = bagInfoList.size();
			if (listSize<= 0||null==bagInfoList) {
				return false;
			}else{
				for(BagInfo bagInfo:bagInfoList){
					bagInfo.setPutStatus("1");
					bagInfo.setWriteStatus("1");
					bagInfoService.save(bagInfo);
				}
			}
			logger.info("横向调拨数据同步成功...**"+PokaDateUtil.getNow()+"**");
			return true;
		} else {
			return false;
		}
		
	}
}
