package com.poka.app.anno.base.service.impl;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.poka.app.anno.enity.BankInfo;
import java.util.Map;

@Service
public class BankInfoService extends BaseService<BankInfo,String> {

	public String getBankIp(String bankId){
		String hql = "from BankInfo b where b.bankNo =:bankId";
		Map<String,String> map = new HashMap();
		map.put("bankId", bankId);
		BankInfo bank  = (BankInfo)baseDao.findUnique(hql, map);
		//System.out.println(bank);
		return bank.getIpAddr();
	}
}
