package com.iiht.evaluation.eloan.dto;

public class LoanDto {
	private int applno;
	private String purpose;
	private int amtSanctioned;
	private int term;
	private float interestRate;
	private int emi;
	private String status;
	private String startDate;
	private String endDate;
	
	public LoanDto() {
		
	}

	public LoanDto(int applno, int amtSanctioned, String purpose, int term, float interestRate, int emi,  String startDate,
			String endDate, String status) {
		super();
		this.applno = applno;
		this.amtSanctioned = amtSanctioned;
		this.term = term;
		this.interestRate = interestRate;
		this.emi = emi;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.purpose = purpose;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getApplno() {
		return applno;
	}
	public void setApplno(int applno) {
		this.applno = applno;
	}
	public int getAmtSanctioned() {
		return amtSanctioned;
	}
	public void setAmtSanctioned(int amtSanctioned) {
		this.amtSanctioned = amtSanctioned;
	}
	public int getEmi() {
		return emi;
	}
	public void setEmi(int emi) {
		this.emi = emi;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}	
	
}
