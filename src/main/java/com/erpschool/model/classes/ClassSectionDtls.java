package com.erpschool.model.classes;

public class ClassSectionDtls {
	
	private Integer id; 
	private String className;
	private String sectionName;
	private String classTeacher;
	private Integer strength;
	
	
	public ClassSectionDtls() {
	}
	
	
	public ClassSectionDtls(Integer id, String className, String sectionName, String classTeacher, Integer strength) {
		super();
		this.id = id;
		this.className = className;
		this.sectionName = sectionName;
		this.classTeacher = classTeacher;
		this.strength = strength;
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
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	
	public String getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}
	public Integer getStrength() {
		return strength;
	}
	public void setStrength(Integer strength) {
		this.strength = strength;
	}


	@Override
	public String toString() {
		return "ClassSectionDtls [id=" + id + ", className=" + className + ", sectionName=" + sectionName
				+ ", classTeacher=" + classTeacher + ", strength=" + strength + "]";
	}
	
	
}
