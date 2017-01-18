package com.poka.app.anno.enity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * 网点配钞
 * @author Administrator
 *
 */
@Entity
@Table(name = "MONEYOUT")
@IdClass(value = MoneyOutPK.class)
public class MoneyOut implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String netId;
	private String scanId;
	private String bagCode;
	private String flag;
	private String operatorId;
	private Timestamp operTime;
	private String remark;
	private String state;
	private String counter;
	private String toCounterUser;
	private Timestamp toCounterDate;
	private String netReceiver;
	private Timestamp netReceiveDate;
	private String fromnetId;
	
	@Id
	@Column(name = "NETID", length = 20)
	public String getNetId() {
		return netId;
	}
	public void setNetId(String netId) {
		this.netId = netId;
	}
	
	@Id
	@Column(name = "SCANID", length = 24)
	public String getScanId() {
		return scanId;
	}
	public void setScanId(String scanId) {
		this.scanId = scanId;
	}
	
	@Id
	@Column(name = "BAGCODE", length = 20)
	public String getBagCode() {
		return bagCode;
	}
	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}
	
	@Column(name = "FLAG", length = 1)
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Column(name = "OPERATORID", length = 20)
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	
	@Column(name = "OPERTIME")
	public Timestamp getOperTime() {
		return operTime;
	}
	public void setOperTime(Timestamp operTime) {
		this.operTime = operTime;
	}
	
	@Column(name = "REMARK", length = 512)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Column(name = "COUNTER", length = 20)
	public String getCounter() {
		return counter;
	}
	public void setCounter(String counter) {
		this.counter = counter;
	}
	
	@Column(name = "TOCOUNTERUSER", length = 20)
	public String getToCounterUser() {
		return toCounterUser;
	}
	public void setToCounterUser(String toCounterUser) {
		this.toCounterUser = toCounterUser;
	}
	
	@Column(name = "toCounterDate")
	public Timestamp getToCounterDate() {
		return toCounterDate;
	}
	public void setToCounterDate(Timestamp toCounterDate) {
		this.toCounterDate = toCounterDate;
	}
	
	@Column(name = "NETRECEIVER", length = 20)
	public String getNetReceiver() {
		return netReceiver;
	}
	public void setNetReceiver(String netReceiver) {
		this.netReceiver = netReceiver;
	}
	
	@Column(name = "NETRECEIVEDATE")
	public Timestamp getNetReceiveDate() {
		return netReceiveDate;
	}
	public void setNetReceiveDate(Timestamp netReceiveDate) {
		this.netReceiveDate = netReceiveDate;
	}
	
	@Column(name = "FROMNETID", length = 20)
	public String getFromnetId() {
		return fromnetId;
	}
	public void setFromnetId(String fromnetId) {
		this.fromnetId = fromnetId;
	}
	
	@Column(name = "STATE", length = 1)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
