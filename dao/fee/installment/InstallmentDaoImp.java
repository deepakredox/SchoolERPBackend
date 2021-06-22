package com.erpschool.dao.fee.installment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.fee.InstallmentDtls;
import com.erpschool.repository.fee.InstallmentCustomQueryRepositoryInterface;

@Component
@Transactional
public class InstallmentDaoImp implements InstallmentDaoInterface {

	@Autowired
	private InstallmentCustomQueryRepositoryInterface installmentCustomQueryRepositoryInterface;

	
	
	@Override
	public Integer addNewInstallmentData(InstallmentDtls installmentDtls) {
		// TODO Auto-generated method stub
		return this.installmentCustomQueryRepositoryInterface.addNewInstallmentData(installmentDtls);
	}

	@Override
	public List<Object[]> getAllInstallment() {
		// TODO Auto-generated method stub
		return this.installmentCustomQueryRepositoryInterface.getAllInstallment();
	}

	@Override
	public Integer deleteInstallmentData(Integer rowId) {
		// TODO Auto-generated method stub
		return this.installmentCustomQueryRepositoryInterface.deleteInstallmentData(rowId);
	}

	@Override
	public Integer editInstallmentData(InstallmentDtls editInstallmentDtls) {
		// TODO Auto-generated method stub
		return this.installmentCustomQueryRepositoryInterface.editInstallmentData(editInstallmentDtls);
	}

}
