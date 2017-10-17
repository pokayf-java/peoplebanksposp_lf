package com.poka.app.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 2017年9月19日09:57:02
 * @author enma.ai
 * 兴业银行同步代理取款数据
 */
public class TAgencyCheck implements Serializable {
	
	private String bagCode;
	private String bankId;
	private String netId;
	private Integer codeType;
	private Date opDate;
	private String opId;
	private Integer sType;
	private Integer syncStates;
	private Date syncDate;
	
	public String getBagCode() {
		return bagCode;
	}
	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}
	
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	public Integer getCodeType() {
		return codeType;
	}
	public void setCodeType(Integer codeType) {
		this.codeType = codeType;
	}
	public Date getOpDate() {
		return opDate;
	}
	public void setOpDate(Date opDate) {
		this.opDate = opDate;
	}
	public String getOpId() {
		return opId;
	}
	public void setOpId(String opId) {
		this.opId = opId;
	}
	public Integer getsType() {
		return sType;
	}
	public void setsType(Integer sType) {
		this.sType = sType;
	}
	public Integer getSyncStates() {
		return syncStates;
	}
	public void setSyncStates(Integer syncStates) {
		this.syncStates = syncStates;
	}
	public Date getSyncDate() {
		return syncDate;
	}
	public void setSyncDate(Date syncDate) {
		this.syncDate = syncDate;
	}
	
}
