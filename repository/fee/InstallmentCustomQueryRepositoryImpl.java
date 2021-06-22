package com.erpschool.repository.fee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.fee.InstallmentDtls;

@Component
@Transactional
public class InstallmentCustomQueryRepositoryImpl implements InstallmentCustomQueryRepositoryInterface {

	@PersistenceContext
	EntityManager em;

	
	
	@Override
	public Integer addNewInstallmentData(InstallmentDtls installmentDtls) {
		// TODO Auto-generated method stub
		String addInstallmentData = "Insert into installmentinfo(INST_NAME, INST_LAST_DATE, INST_MONTHS) values(?,?,?)";
		Query query = em.createNativeQuery(addInstallmentData);
		query.setParameter(1,installmentDtls.getInstallmentName());
		query.setParameter(2,installmentDtls.getInstLastDate());
		query.setParameter(3,installmentDtls.getMonthlyInst());
		
		int rowUpdate = query.executeUpdate();
		return rowUpdate;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllInstallment() {
		
		String getAllInstallmentData = "select * from installmentinfo";
		Query query = em.createNativeQuery(getAllInstallmentData);
		List<Object[]> getAllInstallments = query.getResultList();
		return getAllInstallments;
		
	}

	@Override
	public Integer deleteInstallmentData(Integer rowId) {
	 
		 String delInstallmentData = "DELETE ins from installmentinfo cd where ins.ID = ?";
		 Query query = em.createNativeQuery(delInstallmentData);
		 query.setParameter(1,rowId);
		 Integer rowUpdate = query.executeUpdate();
		 return rowUpdate;
		 
	}

	@Override
	public Integer editInstallmentData(InstallmentDtls editInstallmentDtls) {

		String editInstallmentData = "update installmentinfo set INST_NAME=?,INST_LAST_DATE=?,INST_MONTHS=?  where ID = ?";
		Query query = em.createNativeQuery(editInstallmentData);
		query.setParameter(1,editInstallmentDtls.getInstallmentName());
		query.setParameter(2,editInstallmentDtls.getInstLastDate());
		query.setParameter(3,editInstallmentDtls.getMonthlyInst());
	 
		
		int rowUpdate = query.executeUpdate();
		return rowUpdate;
		
	}

}
