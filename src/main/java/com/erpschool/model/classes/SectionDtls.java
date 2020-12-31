package com.erpschool.model.classes;

public class SectionDtls {
	
	private Integer  id;
	private String sectionName;
	private String abbreviation;
	private int priority;
	
	public SectionDtls(Integer id, String sectionName, String abbreviation, int priority) {
		super();
		this.id = id;
		this.sectionName = sectionName;
		this.abbreviation = abbreviation;
		this.priority = priority;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}


	@Override
	public String toString() {
		return "SectionDtls [id=" + id + ", sectionName=" + sectionName + ", abbreviation=" + abbreviation
				+ ", priority=" + priority + "]";
	}
}
