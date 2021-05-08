package com.erpschool.controller.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.dto.professor.ProfessorDTO;
import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.serviceInterface.professor.ProfessorServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorServiceInterface professorServiceInterface;
	@Autowired
	ServletContext context;

	@PostMapping("/addProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> addnewProfessorData(@RequestBody ProfessorDtls addProfessorDtls, @RequestParam("studentImg") MultipartFile file) {
		
		// ObjectMapper objectMapper = new ObjectMapper();
		// ProfessorDtls professorDtls = objectMapper.readValue(studInfo, ProfessorDtls.class);

		// upload image to server under src/main/webapp and file name save to database
		String imageFileName = uploadImageData(file);
		addProfessorDtls.setUploadImg(imageFileName);
		return professorServiceInterface.addNewProfessorData(addProfessorDtls);
	}

	private String uploadImageData(MultipartFile file) {

		boolean isExist = new File(context.getRealPath("/professorImg/")).exists();
		if (!isExist) {
			new File(context.getRealPath("/professorImg/")).mkdir();
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

	@PutMapping("/editProfessor/{professorId}")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> editProfessorData(@RequestBody ProfessorDtls editProfessorDtls ,@PathVariable Integer professorId) {
		
		return professorServiceInterface.editProfessorData(editProfessorDtls, professorId);
		
	}

	@DeleteMapping("/deleteProfessor/{professorId}")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> deleteProfessorData(@PathVariable Integer professorId) {
		
		return professorServiceInterface.deleteProfessorData(professorId);	
	}

	@GetMapping("/getAllProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDTO>> getAllProfessorData() {

		return professorServiceInterface.getAllProfessorData();
	}
}

