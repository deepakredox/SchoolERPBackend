package com.erpschool.repository.student;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erpschool.model.student.StudentDtls;

@Component
@Transactional
public class StudentCustomQueryRepositoryImpl implements StudentCustomQueryRepositoryInterface {

	@PersistenceContext
	EntityManager em;

	@Override
	public Long saveStudentData(StudentDtls studDTls) {

		String insertStudentData = "Insert into studentinfo(ACADEMIC_YEAR,FIRST_NAME,MIDDLE_NAME,LAST_NAME,CLASS_NAME,SECTION_NAME,ADMISSION_NUMBER,ROLL_NUMBER,GENDER,EMAIL_ID,MOBILE_NUMBER,ADMISSION_DATE,LANDLINE_NUMBER,PARENT_NAME,PARENT_NUMBER,DATE_OF_BIRTH,BLOOD_GROUP,ADDRESS,UPLOAD_IMAGE) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		Query ps1 = em.createNativeQuery(insertStudentData);
		ps1.setParameter(1, studDTls.getAcademicYear());
		ps1.setParameter(2, studDTls.getFirstName());
		ps1.setParameter(3, studDTls.getMiddleName());
		ps1.setParameter(4, studDTls.getLastName());
		ps1.setParameter(5, studDTls.getClassName());
		ps1.setParameter(6, studDTls.getSectionName());
		ps1.setParameter(7, studDTls.getAdmissionNo());
		ps1.setParameter(8, studDTls.getRollNo());
		ps1.setParameter(9, studDTls.getGender());
		ps1.setParameter(10, studDTls.getEmail());
		ps1.setParameter(11, Long.parseLong(studDTls.getMobile()));
		ps1.setParameter(12, studDTls.getAdmissionDate());
		ps1.setParameter(13, Long.parseLong(studDTls.getLandlineNumber()));
		ps1.setParameter(14, studDTls.getParentName());
		ps1.setParameter(15, Long.parseLong(studDTls.getParentNumber()));
		ps1.setParameter(16, studDTls.getStudentDOB());
		ps1.setParameter(17, studDTls.getbGroup());
		ps1.setParameter(18, studDTls.getAddress());
		ps1.setParameter(19, studDTls.getUploadImg());

		ps1.executeUpdate();

		long lastId = ((BigInteger) em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).longValue();

		return lastId;
	}

	@Override
	public Integer updateAdmissionNoByStudentId(StudentDtls studDTls) {

		String sql = "update studentinfo set ADMISSION_NUMBER = ? where STUDENT_ID = ?";
		Query query = em.createNativeQuery(sql);
		query.setParameter(1, studDTls.getAdmissionNo());
		query.setParameter(2, studDTls.getStudId());
		Integer rowUpdate = query.executeUpdate();
		return rowUpdate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllStudentRecord() {

		String getStudentData = "select * from studentinfo";
		Query query = em.createNativeQuery(getStudentData);
		List<Object[]> getAllStudentData = query.getResultList();
		return getAllStudentData;

	}

	@Override
	public Integer deleteStudentData(Integer studAdmnNo) {

		String delStudentData = "DELETE stud from studentinfo stud where stud.ADMISSION_NUMBER = ?";
		Query query = em.createNativeQuery(delStudentData);
		query.setParameter(1, studAdmnNo);
		Integer rowUpdate = query.executeUpdate();
		return rowUpdate;
	}

	@Override
	public Map<String, Integer> getStudImageNameByAdmissionNo(List<Integer> getMultiStudentImage) {

		String getStudImageName = null;
		Map<String, Integer> getStudentData = new HashMap<String, Integer>();
		for (int i = 0; i < getMultiStudentImage.size(); i++) {
			String getStudImageNameQuery = "select UPLOAD_IMAGE from studentinfo stud where stud.ADMISSION_NUMBER = ?";
			Query query = em.createNativeQuery(getStudImageNameQuery);
			query.setParameter(1, getMultiStudentImage.get(i));
			getStudImageName = (String) query.getSingleResult();
			getStudentData.put(getStudImageName, getMultiStudentImage.get(i));
		}
		return getStudentData;
	}
}
