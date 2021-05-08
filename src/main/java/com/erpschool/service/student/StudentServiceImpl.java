package com.erpschool.service.student;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.erpschool.dao.student.StudentDaoInterface;
import com.erpschool.model.student.StudentDtls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

	@Autowired
	private StudentDaoInterface studentDaoInterface;

	@Autowired
	ServletContext context;

	@Override
	public Boolean saveStudentData(String studInfo, MultipartFile file) throws JsonMappingException, JsonProcessingException {

		Boolean saveStudentResult = false;

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			StudentDtls studDTls = objectMapper.readValue(studInfo, StudentDtls.class);

			// Get Student Image Name
			String studentImgName = getStudentImageName(file);

			studDTls.setUploadImg(studentImgName);

			Integer studRecordSave = studentDaoInterface.saveStudentData(studDTls);
			if (studRecordSave == 1) {

				uploadStudentImageInServer(file, studentImgName);
				saveStudentResult = true;
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return saveStudentResult;
	}

	private String getStudentImageName(MultipartFile file) {
		String filename = file.getOriginalFilename();
		String modifiedFileName = FilenameUtils.getBaseName(filename) + "_" + System.currentTimeMillis() + "."
				+ FilenameUtils.getExtension(filename);

		return modifiedFileName;
	}

	private void uploadStudentImageInServer(MultipartFile file, String studentImgName) {

		boolean isExist = new File(context.getRealPath("/studentImage/")).exists();
		if (!isExist) {
			new File(context.getRealPath("/studentImage/")).mkdir();
		}
		File serverfile = new File(context.getRealPath("/studentImage/" + File.separator + studentImgName));

		try {
			FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public List<StudentDtls> getAllStudentsList() {
		
		List<StudentDtls> studentList = new ArrayList<StudentDtls>();
		StudentDtls stud = null;
		List<Object[]> getStudentListData = studentDaoInterface.getAllStudentData();
		for(Object[] obj : getStudentListData )
		{
			stud = new StudentDtls();
			stud.setStudId(Long.parseLong(obj[0].toString()));
			stud.setAcademicYear(obj[1].toString());
			stud.setFirstName(obj[2].toString());
			stud.setMiddleName((obj[3] == null) ? null: obj[3].toString());
			stud.setLastName(obj[4].toString());
			stud.setClassName(obj[5].toString());
			stud.setSectionName(obj[6].toString());
			stud.setAdmissionNo(obj[7].toString());
			stud.setRollNo(Integer.parseInt(obj[8].toString()));
			stud.setGender(obj[9].toString());
			stud.setEmail(obj[10].toString());
			stud.setMobile(obj[11].toString());
			stud.setAdmissionDate(obj[12].toString());
			stud.setLandlineNumber(obj[13].toString());
			stud.setParentName(obj[14].toString());
			stud.setParentNumber(obj[15].toString());
			stud.setStudentDOB(obj[16].toString());
			stud.setbGroup(obj[17].toString());
			stud.setAddress(obj[18].toString());
			stud.setUploadImg(obj[19].toString());
			
			studentList.add(stud);
		}
		return studentList;
	}

	@Override
	public void getAllStudentImage(List<StudentDtls> studentDataList) {

		for (StudentDtls studentsData : studentDataList) {
			String filesPath = context.getRealPath("/studentImage");
			File fileFolder = new File(filesPath);
			if (fileFolder != null) {
				for (final File file : fileFolder.listFiles()) {
					if (!file.isDirectory()) {
						if (studentsData.getUploadImg().equals(file.getName())) {
							String encodeBase64 = null;
							try {
								FileInputStream fileInputStream = new FileInputStream(file);
								byte[] bytes = new byte[(int) file.length()];
								fileInputStream.read(bytes);
								encodeBase64 = Base64.getEncoder().encodeToString(bytes);
								studentsData.setUploadImg(encodeBase64);
								fileInputStream.close();
							} catch (Exception e) {
								// TODO: handle exception
							}
						}
					}
				}
			}
		}

	}

	@Override
	public Integer deleteStudentData(String studAdmnNo) {
		
		return studentDaoInterface.deleteStudentData(studAdmnNo);
	}
}
