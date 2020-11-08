package com.iiht.evaluation.eloan.model;

public class LoanInfo {
	private int applno;
	 private String purpose;
	 private int amtrequest;
	 private String doa;
	 private String bstructure;
	 private String bindicator;
	 private String address;
	 @Override
	public String toString() {
		return "LoanInfo [applno=" + applno + ", purpose=" + purpose + ", amtrequest=" + amtrequest + ", doa=" + doa
				+ ", bstructure=" + bstructure + ", bindicator=" + bindicator + ", address=" + address + ", email="
				+ email + ", mobile=" + mobile + ", status=" + status + "]";
	}
	private String email;
	 private String mobile;
	 private String status;
	 public LoanInfo() {
		 
	 }
	 public LoanInfo(int applno, String purpose, int amtrequest, String doa, String bstructure, String bindicator,
			String address, String email, String mobile,String status) {
		super();
		this.applno = applno;
		this.purpose = purpose;
		this.amtrequest = amtrequest;
		this.doa = doa;
		this.bstructure = bstructure;
		this.bindicator = bindicator;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.status=status;
	}

	public int getApplno() {
		return applno;
	}
	public void setApplno(int applno) {
		this.applno = applno;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getAmtrequest() {
		return amtrequest;
	}
	public void setAmtrequest(int amtrequest) {
		this.amtrequest = amtrequest;
	}
	public String getDoa() {
		return doa;
	}
	public void setDoa(String doa) {
		this.doa = doa;
	}
	public String getBstructure() {
		return bstructure;
	}
	public void setBstructure(String bstructure) {
		this.bstructure = bstructure;
	}
	public String getBindicator() {
		return bindicator;
	}
	public void setBindicator(String bindicator) {
		this.bindicator = bindicator;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	public String getStatus() {
		return status;
	}

}
