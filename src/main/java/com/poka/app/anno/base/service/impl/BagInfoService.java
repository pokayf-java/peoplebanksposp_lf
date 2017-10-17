package com.poka.app.anno.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poka.app.anno.base.dao.impl.BagInfoDao;
import com.poka.app.anno.bussiness.BagInfoBusiness;
import com.poka.app.anno.enity.BagInfo;
import com.poka.app.anno.enity.BagInfoPK;
import com.poka.app.util.PokaDateUtil;
import com.poka.app.vo.TAgencyCheck;

@Service
public class BagInfoService extends BaseService<BagInfo, BagInfoPK> {

	private BagInfoDao bagInfoDao;
	Logger logger = Logger.getLogger(BagInfoBusiness.class);

	@Autowired
	public void setBagInfoDao(BagInfoDao bagInfoDao) {
		this.bagInfoDao = bagInfoDao;
	}

	public List<BagInfo> getBagInfoList(String bankNo) {
		String hql = "from BagInfo b where b.bankId = :bankId and b.writeStatus ='1'";
		Query query = createQuery(hql);
		query.setParameter("bankId", bankNo);
		return (List<BagInfo>) query.list();
	}

	public void updateBagInfoStatus(String bankNo) {
		String hql = " update BagInfo b set b.writeStatus ='0' where b.bankId =:bankId and b.writeStatus ='1'";
		Map<String, Object> map = new HashMap();
		map.put("bankId", bankNo);
		this.getBaseDao().batchExecute(hql, map);
	}

	/**
	 * 兴业银行代理取款下发 2017年9月19日
	 * 
	 * @author Enma.ai
	 * @return boolean
	 * @param checks
	 * @return
	 */
	public boolean dealChecks(List<TAgencyCheck> checks) {
		// 遍历List，区分codetype做不同操作
		try {
			for (TAgencyCheck tAgencyCheck : checks) {
				int codeType = tAgencyCheck.getCodeType();
				// 捆标签的处理
				if (1 == codeType) {
					bagInfoDao.saveBundleCode(tAgencyCheck);
				
				// 袋标签的处理
				} else if (0 == codeType) {
					bagInfoDao.saveBagCode(tAgencyCheck);
					
				// 异常情况
				} else {
					logger.info("该笔数据异常，同步取消**" + PokaDateUtil.getNow() + "**");
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		logger.info("兴业银行代理取款下发处理成功！...**" + PokaDateUtil.getNow() + "**");
		return true;
	}

}
