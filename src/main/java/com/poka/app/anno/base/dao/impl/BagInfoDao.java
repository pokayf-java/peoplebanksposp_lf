package com.poka.app.anno.base.dao.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.poka.app.anno.enity.BagInfo;
import com.poka.app.anno.enity.BagInfoPK;
import com.poka.app.vo.TAgencyCheck;

@Repository
public class BagInfoDao extends BaseDao<BagInfo, BagInfoPK> {
	
	/**
	 * 兴业银行提交袋标签
	 * 2017年9月20日
	 * @author Enma.ai
	 * @return void
	 * @param tAgencyCheck
	 */
	@SuppressWarnings("unchecked")
	public void saveBagCode(TAgencyCheck tAgencyCheck) {
		String hql = "from BagInfo b where b.bagCode = :bagCode";
		Query query = createQuery(hql);
		query.setParameter("bagCode", tAgencyCheck.getBagCode());
		List<BagInfo> bundleList = (List<BagInfo>)query.list();
		for (BagInfo bundle : bundleList) {
			String sql = "insert into baginfo "
					+ "(BAGCODE,"
					+ " BANKID,"
					+ " BAGDATE,"
					+ " BAGBAGID,"
					+ " BAGCHECKID,"
					+ " BUNDLECODE,"
					+ " BUNDLEDATE,"
					+ " WRITESTATUS,"
					+ " PUTSTATUS,"
					+ " INSERTDATE)"
					+ " values ('"
					+ tAgencyCheck.getBagCode() + "', '"
					+ tAgencyCheck.getBankId() + "', "
					+ "to_date('" + new SimpleDateFormat("dd-MM-yyyy").format(bundle.getBagDate()) + "', 'dd-mm-yyyy'), '"	
					+ bundle.getBagBagId() + "', '"
					+ bundle.getBagCheckId() + "', '"
					+ bundle.getBundleCode() + "', "
					+ "to_date('" + new SimpleDateFormat("dd-MM-yyyy").format(bundle.getBundleDate()) + "', 'dd-mm-yyyy'), "
					+ "'0', "
					+ "'1', "
					+ "sysdate"
					+ ")";
			this.getSession().createSQLQuery(sql).executeUpdate();
		}
	}
	
	/**
	 * 兴业银行提交捆标签
	 * 2017年9月20日
	 * @author Enma.ai
	 * @return void
	 * @param tAgencyCheck
	 */
	public void saveBundleCode(TAgencyCheck tAgencyCheck) {
		String sql = "insert into baginfo "
				+ "(BAGCODE,"
				+ " BANKID,"
				+ " BAGDATE,"
				+ " BAGBAGID,"
				+ " BAGCHECKID,"
				+ " BUNDLECODE,"
				+ " BUNDLEDATE,"
				+ " WRITESTATUS,"
				+ " PUTSTATUS,"
				+ " INSERTDATE)"
				+ " values ('"
				+ "00000000000000000000', '"
				+ tAgencyCheck.getBankId() + "', "
				+ "to_date('" + new SimpleDateFormat("dd-MM-yyyy").format(tAgencyCheck.getOpDate()) + "', 'dd-mm-yyyy'), '"	
				+ tAgencyCheck.getOpId() + "', '"
				+ tAgencyCheck.getOpId() + "', '"
				+ tAgencyCheck.getBagCode() + "', "
				+ "to_date('" + new SimpleDateFormat("dd-MM-yyyy").format(tAgencyCheck.getOpDate()) + "', 'dd-mm-yyyy'), "
				+ "'0', "
				+ "'1', "
				+ "sysdate"
				+ ")";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
}
