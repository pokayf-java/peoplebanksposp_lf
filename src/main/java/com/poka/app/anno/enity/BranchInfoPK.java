package com.poka.app.anno.enity;

import java.io.Serializable;

public class BranchInfoPK implements Serializable{
	private String bankno;
	private String agencyno;
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof BranchInfoPK){
			BranchInfoPK pk = (BranchInfoPK)obj;
			if(pk.getBankno().equals(this.bankno)&&pk.getAgencyno().equals(this.agencyno)){
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return (this.getBankno()+this.getAgencyno()).hashCode();
	}
	
	public String getBankno() {
		return bankno;
	}
	public void setBankno(String bankno) {
		this.bankno = bankno;
	}
	
	
	public String getAgencyno() {
		return agencyno;
	}
	public void setAgencyno(String agencyno) {
		this.agencyno = agencyno;
	}
	
	
}
