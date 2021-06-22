package com.erpschool.model.fee;

public class InstallmentDtls {
	
	
	private Integer id; 
	private String installmentName;
	private String instLastDate;
	private String monthlyInst;
	
	
	public InstallmentDtls() {}

	


	public InstallmentDtls(Integer id, String installmentName, String instLastDate, String monthlyInst) {
		super();
		this.id = id;
		this.installmentName = installmentName;
		this.instLastDate = instLastDate;
		this.monthlyInst = monthlyInst;
	}



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getInstallmentName() {
		return installmentName;
	}


	public void setInstallmentName(String installmentName) {
		this.installmentName = installmentName;
	}


	public String getInstLastDate() {
		return instLastDate;
	}


	public void setInstLastDate(String instLastDate) {
		this.instLastDate = instLastDate;
	}


	public String getMonthlyInst() {
		return monthlyInst;
	}


	public void setMonthlyInst(String monthlyInst) {
		this.monthlyInst = monthlyInst;
	}

 
	

	@Override
	public String toString() {
		return "InstallmentDtls [id=" + id + ", installmentName=" + installmentName + ", instLastDate=" + instLastDate
				+ ", monthlyInst=" + monthlyInst + "]";
	}



}
