package com.erpschool.model.student;

public class StudentDtls {

	private Long studId;
	private String academicYear;
	private String firstName;
	private String middleName;
	private String lastName;
	private String className;
	private String sectionName;
	private String admissionNo;
	private Integer rollNo;
	private String gender;
	private String email;
	private String mobile;
	private String admissionDate;
	private String landlineNumber;
	private String parentName;
	private String parentNumber;
	private String studentDOB;
	private String bGroup;
	private String address;
	private String uploadImg;

	public StudentDtls() {
	}

	public StudentDtls(Long studId, String academicYear, String firstName, String middleName, String lastName,
			String className, String sectionName, String admissionNo, Integer rollNo, String gender, String email,
			String mobile, String admissionDate, String landlineNumber, String parentName, String parentNumber,
			String studentDOB, String bGroup, String address, String uploadImg) {
		super();
		this.studId = studId;
		this.academicYear = academicYear;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.className = className;
		this.sectionName = sectionName;
		this.admissionNo = admissionNo;
		this.rollNo = rollNo;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.admissionDate = admissionDate;
		this.landlineNumber = landlineNumber;
		this.parentName = parentName;
		this.parentNumber = parentNumber;
		this.studentDOB = studentDOB;
		this.bGroup = bGroup;
		this.address = address;
		this.uploadImg = uploadImg;
	}

	public Long getStudId() {
		return studId;
	}

	public void setStudId(Long studId) {
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

	@Override
	public String toString() {
		return "StudentDtls [studId=" + studId + ", academicYear=" + academicYear + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", className=" + className
				+ ", sectionName=" + sectionName + ", admissionNo=" + admissionNo + ", rollNo=" + rollNo + ", gender="
				+ gender + ", email=" + email + ", mobile=" + mobile + ", admissionDate=" + admissionDate
				+ ", landlineNumber=" + landlineNumber + ", parentName=" + parentName + ", parentNumber=" + parentNumber
				+ ", studentDOB=" + studentDOB + ", bGroup=" + bGroup + ", address=" + address + ", uploadImg="
				+ uploadImg + "]";
	}

}
