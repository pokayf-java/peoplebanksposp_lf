package com.poka.app.anno.enity;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * 网点配钞
 * 
 * @author Administrator
 *
 */
public class MoneyOutPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private String netId;
	private String scanId;
	private String bagCode;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MoneyOutPK) {
			MoneyOutPK pk = (MoneyOutPK) obj;
			if (pk.getBagCode().equals(this.getBagCode()) && pk.getScanId().equals(this.scanId)
					&& pk.getNetId().equals(this.netId)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (this.getNetId() + this.getBagCode() + this.getScanId()).hashCode();
	}

	@Column(name = "BagCode", length = 20)
	public String getBagCode() {
		return bagCode;
	}

	public void setBagCode(String bagCode) {
		this.bagCode = bagCode;
	}

	@Column(name = "NETID", length = 20)
	public String getNetId() {
		return netId;
	}

	public void setNetId(String netId) {
		this.netId = netId;
	}

	@Column(name = "SCANID", length = 24)
	public String getScanId() {
		return scanId;
	}

	public void setScanId(String scanId) {
		this.scanId = scanId;
	}

}
