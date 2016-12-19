package com.poka.app.anno.enity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class BankCheckDailyRepListPK implements Serializable {

	private String bankNo;
	private String checkDate;
	private BigDecimal monVal;
	private BigInteger records;
	private String operDate;
	private Timestamp logDate;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BankCheckDailyRepListPK) {
			BankCheckDailyRepListPK pk = (BankCheckDailyRepListPK) obj;
			if (pk.getBankNo().equals(this.bankNo) && pk.getCheckDate().equals(this.checkDate)
					&& pk.getMonVal().equals(this.monVal) && pk.getRecords().equals(this.records)
					&& pk.getOperDate().equals(this.operDate) && pk.getLogDate().equals(this.logDate)) {
				return true;
			}

		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.getBankNo() + this.getCheckDate() + this.getMonVal() + this.getRecords() + this.getOperDate()
				+ this.getLogDate()).hashCode();
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public BigDecimal getMonVal() {
		return monVal;
	}

	public void setMonVal(BigDecimal monVal) {
		this.monVal = monVal;
	}

	public BigInteger getRecords() {
		return records;
	}

	public void setRecords(BigInteger records) {
		this.records = records;
	}

	public String getOperDate() {
		return operDate;
	}

	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}

	public Timestamp getLogDate() {
		return logDate;
	}

	public void setLogDate(Timestamp logDate) {
		this.logDate = logDate;
	}
}
