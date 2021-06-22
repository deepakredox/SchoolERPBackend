package com.erpschool.repository.fee;

import java.util.List;

import com.erpschool.model.fee.InstallmentDtls;

 

public interface InstallmentCustomQueryRepositoryInterface {

	Integer addNewInstallmentData(InstallmentDtls installmentDtls);

	List<Object[]> getAllInstallment();

	Integer deleteInstallmentData(Integer rowId);

	Integer editInstallmentData(InstallmentDtls editInstallmentDtls);

}
