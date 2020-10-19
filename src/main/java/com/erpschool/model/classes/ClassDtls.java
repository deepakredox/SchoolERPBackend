package com.erpschool.model.classes;

public class ClassDtls {
	
	private Integer id; 
	private String className;
	private String abbreviation;
	private int priority;

	public ClassDtls(Integer id, String className, String abbreviation, int priority) {
		super();
		this.id = id;
		this.className = className;
		this.abbreviation = abbreviation;
		this.priority = priority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
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
		return "ClassDtls [id=" + id + ", className=" + className + ", abbreviation=" + abbreviation + ", priority="
				+ priority + "]";
	}
}
