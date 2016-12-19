package com.poka.app.anno.base.service.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.poka.app.anno.enity.NetCheckDailyRepList;
import com.poka.app.anno.enity.NetCheckDailyRepListPK;

@Service
public class NetCheckDailyRepListService extends BaseService<NetCheckDailyRepList, NetCheckDailyRepListPK> {
	
	public List<NetCheckDailyRepList> getNetCheckDailyRep(){
		String hql = " FROM NetCheckDailyRepList ";
		Query query = createQuery(hql);
		return (List<NetCheckDailyRepList>)query.list();
	}

}
