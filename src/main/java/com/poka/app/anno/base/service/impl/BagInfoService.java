package com.poka.app.anno.base.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.poka.app.anno.enity.BagInfo;
import com.poka.app.anno.enity.BagInfoPK;

@Service
public class BagInfoService extends BaseService<BagInfo, BagInfoPK> {
	
	public List<BagInfo> getBagInfoList(String bankNo){
		String hql = "from BagInfo b where b.bankId = :bankId and b.writeStatus ='1'";
		Query query = createQuery(hql);
		query.setParameter("bankId",bankNo);
		return (List<BagInfo>)query.list();
	}

	public void updateBagInfoStatus(String bankNo){
		String hql = " update BagInfo b set b.writeStatus ='0' where b.bankId =:bankId and b.writeStatus ='1'";
		Map<String, Object> map = new HashMap();
		map.put("bankId", bankNo);
		this.getBaseDao().batchExecute(hql,map);
	}

}
