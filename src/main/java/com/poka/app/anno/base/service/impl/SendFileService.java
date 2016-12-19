package com.poka.app.anno.base.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.poka.app.anno.enity.SendFile;
import com.poka.app.anno.enity.SendFilePK;

@Service
public class SendFileService extends BaseService<SendFile, SendFilePK> {

	public List<SendFile> getSendFileList() {
		
		
		String hql = "FROM SendFile where sendDate like to_date(to_char(sysdate-1,'yyyy-mm-dd'),'yyyy-mm-dd')";
//		SQLQuery query = this.getBaseDao().getSession().createSQLQuery(sql);
//		query.addEntity(SendFile.class);
		Query query = createQuery(hql);
		return (List<SendFile>) query.list();
	}

}
