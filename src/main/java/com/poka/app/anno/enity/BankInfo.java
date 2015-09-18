package com.poka.app.anno.enity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BankInfo")
public class BankInfo implements Serializable {
	private String bankNo;
	private String bankName;
	private String ipAddr;
	private String ipport;
	private String address;
	private String telphone;
	private String remark;
	@Override
	public String toString() {
		return "BankInfo [bankNo=" + bankNo + ", bankName=" + bankName
				+ ", ipAddr=" + ipAddr + ", ipport=" + ipport + ", address="
				+ address + ", telphone=" + telphone + ", remark=" + remark
				+ "]";
	}
	@Id
	@Column(name = "bankno",length=20)
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	@Column(name = "bankname",length=150)
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Column(name = "ipaddr",length=20)
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	@Column(name = "ipport",length=8)
	public String getIpport() {
		return ipport;
	}
	public void setIpport(String ipport) {
		this.ipport = ipport;
	}
	
	@Column(name = "address",length=80)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name = "telphone",length=20)
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	@Column(name = "remark",length=512)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
