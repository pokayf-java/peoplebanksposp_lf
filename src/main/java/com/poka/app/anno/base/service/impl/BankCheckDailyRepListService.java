package com.poka.app.anno.base.service.impl;


import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.poka.app.anno.enity.BankCheckDailyRepList;
import com.poka.app.anno.enity.BankCheckDailyRepListPK;

@Service
public class BankCheckDailyRepListService extends BaseService<BankCheckDailyRepList, BankCheckDailyRepListPK> {
	
	public List<BankCheckDailyRepList> getBankCheckDailyRepList(){
		String hql = " FROM BankCheckDailyRepList ";
		Query query = createQuery(hql);
		return (List<BankCheckDailyRepList>)query.list();
	}

}
