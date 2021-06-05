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
import com.erpschool.model.professor.ProfessorDtls;
import com.erpschool.service.professor.ProfessorServiceInterface;
// import com.erpschool.service.professor.ProfessorServiceInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

@RestController
@CrossOrigin(origins = "http://localhost:4201")
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorServiceInterface professorServiceInterface;

	@Autowired
	ServletContext context;

	ResponseObjectXML<ProfessorDtls> responseObjectXML = new ResponseObjectXML<ProfessorDtls>();

	@PostMapping("/addProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDtls>> addnewProfessorData(
			@RequestParam("professorObj") String professorInfo, @RequestParam("professorImg") MultipartFile file)
			throws JsonMappingException, JsonProcessingException {

		   List<ProfessorDtls> addNewProfessor = new ArrayList<ProfessorDtls>();
		   Boolean result = professorServiceInterface.addNewProfessor(professorInfo, file);
		   if (result == true) {

			// response send back to UI
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Professor has been Added");
			responseObjectXML.setData(addNewProfessor);
			return new ResponseEntity<ResponseObjectXML<ProfessorDtls>>(responseObjectXML, HttpStatus.OK);
		} else {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error in saving Professor");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDtls>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}

	// private String uploadImageData(MultipartFile file) {

	// 	boolean isExist = new File(context.getRealPath("/professorImg/")).exists();
	// 	if (!isExist) {
	// 		new File(context.getRealPath("/professorImg/")).mkdir();
	// 	}
	// 	String filename = file.getOriginalFilename();
	// 	String modifiedFileName = FilenameUtils.getBaseName(filename) + "_" + System.currentTimeMillis() + "."
	// 			+ FilenameUtils.getExtension(filename);
	// 	File serverfile = new File(context.getRealPath("/studentImage/" + File.separator + modifiedFileName));

	// 	try {
	// 		FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
	// 	} catch (Exception e) {
	// 		// TODO: handle exception
	// 	}
	// 	return modifiedFileName;
	// }

	@PutMapping("/editProfessor/{professorId}")
	public ResponseEntity<ResponseObjectXML<ProfessorDtls>> editProfessorData(
			@RequestBody ProfessorDtls editProfessorDtls, @PathVariable Integer professorId) {

		   Boolean isProfessorEditSuccess = professorServiceInterface.editProfessor(editProfessorDtls, professorId);
		   return null;

	}

	// @DeleteMapping("/deleteProfessor/{professorId}")
	// public ResponseEntity<ResponseObjectXML<ProfessorDTO>> deleteProfessorData(@PathVariable Integer professorId) {

	// 	return professorServiceInterface.deleteProfessorData(professorId);
	// }

	@GetMapping("/getAllProfessor")
	public ResponseEntity<ResponseObjectXML<ProfessorDtls>> getAllProfessorData() {
		
		try {
			List<ProfessorDtls> allProfessorData = professorServiceInterface.getAllProfessor();
			if (allProfessorData.size() == 0) {
				System.out.println("Size1" + allProfessorData.size());
				responseObjectXML.setStatusCode(HttpStatus.NOT_FOUND.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(allProfessorData);
				return new ResponseEntity<ResponseObjectXML<ProfessorDtls>>(responseObjectXML, HttpStatus.OK);
			} else {
				// Get All Student Images
				// professorServiceInterface.getAllStudentImage(getStudentData);

				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Student Data Fetch Successfully");
				responseObjectXML.setData(allProfessorData);
				return new ResponseEntity<ResponseObjectXML<ProfessorDtls>>(responseObjectXML, HttpStatus.OK);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
			return new ResponseEntity<ResponseObjectXML<ProfessorDtls>>(responseObjectXML, HttpStatus.BAD_REQUEST);
		}
	}
}
