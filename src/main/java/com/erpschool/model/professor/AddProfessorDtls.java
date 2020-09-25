package com.erpschool.model.professor;

public class AddProfessorDtls {
	
	private String firstname;
	private String lastname;
	private String gender;
	private String mobile;
	private String password;
	private String conformPassword;
	private String designation;
	private String department;
	private String address;
	private String email;
	private String dob;
	private String education;
	private String uploadImg;
	
	
	public AddProfessorDtls(String firstname, String lastname, String gender, String mobile, String password,
			String conformPassword, String designation, String department, String address, String email, String dob,
			String education, String uploadImg) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.mobile = mobile;
		this.password = password;
		this.conformPassword = conformPassword;
		this.designation = designation;
		this.department = department;
		this.address = address;
		this.email = email;
		this.dob = dob;
		this.education = education;
		this.uploadImg = uploadImg;
	}


	public String getFirstname() {
		return (firstname == "") ? "(NULL)" : firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return (lastname == "") ? "(NULL)" : lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return (gender == "") ? "(NULL)" : gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return (mobile == "") ? "(NULL)" : mobile; 
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return (password == "") ? "(NULL)" : password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConformPassword() {
		return (conformPassword == "") ? "(NULL)" : conformPassword;
	}

	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}

	public String getDesignation() {
		return (designation == "") ? "(NULL)" : designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return (department == "") ? "(NULL)" : department; 
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAddress() {
		return (address == "") ? "(NULL)" : address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return (email == "") ? "(NULL)" : email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return (dob == "") ? "(NULL)" : dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEducation() {
		return (education == "") ? "(NULL)" : education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getUploadImg() {
		return (uploadImg == "") ? "(NULL)" : uploadImg;
	}

	public void setUploadImg(String uploadImg) {
		this.uploadImg = uploadImg;
	}


	@Override
	public String toString() {
		return "AddProfessorDtls [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", mobile=" + mobile + ", password=" + password + ", conformPassword=" + conformPassword
				+ ", designation=" + designation + ", department=" + department + ", address=" + address + ", email="
				+ email + ", dob=" + dob + ", education=" + education + ", uploadImg=" + uploadImg + "]";
	}
}
