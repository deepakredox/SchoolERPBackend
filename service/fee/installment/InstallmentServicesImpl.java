package com.erpschool.service.fee.installment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erpschool.dao.fee.installment.InstallmentDaoInterface;
import com.erpschool.model.fee.InstallmentDtls;

@Service
public class InstallmentServicesImpl implements InstallmentServiceInterface{

	@Autowired
	private InstallmentDaoInterface installmentDaoInterface;
	
	@Override
	public Integer addNewInstallmentData(InstallmentDtls installmentDtls) {
		// TODO Auto-generated method stub
		System.out.println(" > "+installmentDtls);
		return this.installmentDaoInterface.addNewInstallmentData(installmentDtls);
	}

	@Override
	public List<InstallmentDtls> getAllInstallment() {
		// TODO Auto-generated method stub
//		return this.installmentDaoInterface.getAllInstallment();
		
		List<InstallmentDtls> installmentList = new ArrayList<InstallmentDtls>();
		InstallmentDtls installmentData = null;
		
		List<Object[]> getInstallmentData = installmentDaoInterface.getAllInstallment();
		
		for(Object[] obj : getInstallmentData)
		{
			installmentData = new InstallmentDtls();	
			
			installmentData.setId(Integer.parseInt(obj[0].toString()));
			installmentData.setInstallmentName(obj[1].toString());
			installmentData.setInstLastDate(obj[2].toString());
			installmentData.setMonthlyInst(obj[3].toString());
		  
			installmentList.add(installmentData);
		}
		
		return installmentList;
	}
	 

	@Override
	public Integer deleteCInstallmentData(Integer rowId) {
		// TODO Auto-generated method stub
		return this.deleteCInstallmentData(rowId);
	}

	@Override
	public Integer editInstallmentData(InstallmentDtls editInstallmentDtls) {
		// TODO Auto-generated method stub
		return this.installmentDaoInterface.editInstallmentData(editInstallmentDtls);
	}

}
