package com.erpschool.controller.fee;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.model.fee.InstallmentDtls;

import com.erpschool.service.fee.installment.InstallmentServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/fees")
public class FeeController {

 
	@Autowired
	private InstallmentServiceInterface installmentServiceInterface;

	ResponseObjectXML<InstallmentDtls> responseObjectXML = new ResponseObjectXML<InstallmentDtls>();

	@PostMapping("/addfeesinstallment")
	public ResponseEntity<ResponseObjectXML<InstallmentDtls>> addfeesinstallment(@RequestBody InstallmentDtls installmentDtls) {
		
		List<InstallmentDtls> addInstallmentData = new ArrayList<InstallmentDtls>();
		Integer getRecordUpdate = installmentServiceInterface.addNewInstallmentData(installmentDtls);
		
		if (getRecordUpdate == 1) {
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("New Installment has been Added");
			responseObjectXML.setData(addInstallmentData);
		} else {
			// TODO Auto-generated catch block
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Errro in saving data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<InstallmentDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@PutMapping("/editfeesinstallment")
	public ResponseEntity<ResponseObjectXML<InstallmentDtls>> editInstallmentData(@RequestBody InstallmentDtls editinstallmentDtls) {
		
		 
		List<InstallmentDtls> editInstallmentData = new ArrayList<InstallmentDtls>();
		Integer rowDeletedStatus =  installmentServiceInterface.editInstallmentData(editinstallmentDtls);
		if(rowDeletedStatus == 1)
		{
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Installment Data Update Successfully");
			responseObjectXML.setData(editInstallmentData);	
		}
		else
		{
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while edit the Class Data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<InstallmentDtls>>(responseObjectXML, HttpStatus.OK);
	}

	@DeleteMapping("/deletefeesinstallment/{rowId}")
	public ResponseEntity<ResponseObjectXML<InstallmentDtls>> deleteInstallmentData(@PathVariable("rowId") Integer rowId) {
		
		List<InstallmentDtls> installmentDelData = new ArrayList<InstallmentDtls>();
		Integer rowDeletedStatus =  installmentServiceInterface.deleteCInstallmentData(rowId);
		if(rowDeletedStatus == 1)
		{
			responseObjectXML.setStatusCode(HttpStatus.OK.value());
			responseObjectXML.setMessage("Installment Data delete Successfully");
			responseObjectXML.setData(installmentDelData);
		}
		else
		{
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while deleting the Class data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<InstallmentDtls>>(responseObjectXML, HttpStatus.OK); 
	}

	@GetMapping("getAllfeesInstallment")
	public ResponseEntity<ResponseObjectXML<InstallmentDtls>> getAllInstallment() {
		
		System.out.println("Get all Installment");
		List<InstallmentDtls> getInstallmentData = installmentServiceInterface.getAllInstallment();
		
		try {
			
			if (getInstallmentData.size() == 0) {
				System.out.println("Size1"+getInstallmentData.size());
				responseObjectXML.setStatusCode(HttpStatus.NO_CONTENT.value());
				responseObjectXML.setMessage("No records found");
				responseObjectXML.setData(getInstallmentData);
			}
			else
			{
				responseObjectXML.setStatusCode(HttpStatus.OK.value());
				responseObjectXML.setMessage("Data Fetch Successfully");
				responseObjectXML.setData(getInstallmentData);
			}
		} catch (Exception e) {
			responseObjectXML.setStatusCode(HttpStatus.BAD_REQUEST.value());
			responseObjectXML.setMessage("Error while getting the data");
			responseObjectXML.setData(null);
		}
		return new ResponseEntity<ResponseObjectXML<InstallmentDtls>>(responseObjectXML, HttpStatus.OK);
	}
}
