package com.erpschool.controller.student;

import java.io.File;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.erpschool.model.student.StudentDtls;
import com.erpschool.serviceInterface.student.StudentServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentServiceInterface studServiceInterface;
	
	
	@Autowired
	ServletContext context;

	@PostMapping("/addstudent")
	public void addStudent(@RequestParam("studInfo") String studInfo ,@RequestParam("studImg") MultipartFile file) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		StudentDtls studDTls = objectMapper.readValue(studInfo, StudentDtls.class);
		
		// upload image to server under src/main/webapp and file name save to database
		String imageFileName = uploadImageData(file);
		
		studDTls.setUploadImg(imageFileName);
		
		// Student details save to Database
		studServiceInterface.addStudent(studDTls);
		
	}

	private String uploadImageData(MultipartFile file) {
		
		boolean isExist = new File(context.getRealPath("/studentImage/")).exists();
		if (!isExist) {
			new File(context.getRealPath("/studentImage/")).mkdir();
		}
		String filename = file.getOriginalFilename();
		String modifiedFileName = FilenameUtils.getBaseName(filename) + "_" + System.currentTimeMillis() + "."
				+ FilenameUtils.getExtension(filename);
		File serverfile = new File(context.getRealPath("/studentImage/" + File.separator + modifiedFileName));

		try {
			FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return modifiedFileName;
	}
}


