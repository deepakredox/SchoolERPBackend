package com.erpschool.dto.student;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentinfo")
public class StudentDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="STUDENT_ID")
	private Integer studId;
	
	@Column(name="ACADEMIC_YEAR")
	private String academicYear; 
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="MIDDLE_NAME")
	private String middleName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="CLASS_NAME")
	private String className;
	
	@Column(name="SECTION_NAME")
	private String sectionName;
	
	@Column(name="ADMISSION_NUMBER")
	private String admissionNo;
	
	@Column(name="ROLL_NUMBER")
	private Integer rollNo;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="MOBILE_NUMBER")
	private String mobile;
	
	@Column(name="ADMISSION_DATE")
	private String admissionDate;
	
	@Column(name="LANDLINE_NUMBER")
	private String landlineNumber;
	
	@Column(name="PARENT_NAME")
	private String parentName;
	
	@Column(name="PARENT_NUMBER")
	private String parentNumber;
	
	@Column(name="DATE_OF_BIRTH")
	private String studentDOB;
	
	@Column(name="BLOOD_GROUP")
	private String bGroup;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="UPLOAD_IMAGE")
	private String uploadImg;

	public Integer getStudId() {
		return studId;
	}

	public void setStudId(Integer studId) {
		this.studId = studId;
	}

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAdmissionNo() {
		return admissionNo;
	}

	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}

	public String getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getbGroup() {
		return bGroup;
	}

	public void setbGroup(String bGroup) {
		this.bGroup = bGroup;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUploadImg() {
		return uploadImg;
	}

	public void setUploadImg(String uploadImg) {
		this.uploadImg = uploadImg;
	}
}
