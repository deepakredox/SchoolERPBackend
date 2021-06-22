package com.erpschool.service.fee.installment;

import java.util.List;

import com.erpschool.model.fee.InstallmentDtls;

public interface InstallmentServiceInterface {

	
	Integer addNewInstallmentData(InstallmentDtls installmentDtls);

	List<InstallmentDtls> getAllInstallment();

	Integer deleteCInstallmentData(Integer rowId);

	Integer editInstallmentData(InstallmentDtls editInstallmentDtls);

}
