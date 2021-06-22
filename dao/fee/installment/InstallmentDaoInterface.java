package com.erpschool.dao.fee.installment;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erpschool.model.fee.InstallmentDtls;

@Repository
public interface InstallmentDaoInterface {
	
	
	Integer addNewInstallmentData(InstallmentDtls installmentDtls);

	List<Object[]> getAllInstallment();

	Integer deleteInstallmentData(Integer rowId);

	Integer editInstallmentData(InstallmentDtls editInstallmentDtls);

}
