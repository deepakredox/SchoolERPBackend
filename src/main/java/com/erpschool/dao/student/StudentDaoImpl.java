package com.erpschool.dao.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.erpschool.apiresponse.ResponseObjectXML;
import com.erpschool.model.student.StudentDtls;
import com.erpschool.repository.student.CustomQueryRepositoryInterface;

@Component
@Transactional
public class StudentDaoImpl implements StudentDaoInterface {

	@Autowired
	private CustomQueryRepositoryInterface customQueryRepositoryInterface;

	ResponseObjectXML<StudentDtls> responseObjectXML = new ResponseObjectXML<StudentDtls>();

	@Override
	public Integer saveStudentData(StudentDtls studDTls) {
		
		Integer rowResults = 0;

		try {
			String admissionYear = studDTls.getAdmissionDate().substring(2, 4);

			studDTls.setAdmissionDate(studDTls.getAdmissionDate().substring(0, 10));
			studDTls.setStudentDOB(studDTls.getStudentDOB().substring(0, 10));

			Long pkValData = customQueryRepositoryInterface.saveStudentData(studDTls);
			
			studDTls.setStudId(pkValData);
			studDTls.setAdmissionNo(String.format(admissionYear + "%04d", pkValData));
			rowResults = customQueryRepositoryInterface.updateStudentByAdmissionNo(studDTls);
			return rowResults;
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return rowResults;
	}

	@Override
	public List<StudentDtls> getAllStudentData() {
		
		return customQueryRepositoryInterface.getAllStudentRecord();
	}
}
