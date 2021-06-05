package com.erpschool.repository.professor;

import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.erpschool.model.professor.ProfessorDtls;
import java.math.BigInteger;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class ProfessorRepositoryImpl implements ProfessorRepositoryInterface {

    @PersistenceContext
    EntityManager em;
    private List<Object[]> availableProfessors;

    @Override
    public Integer addProfessorDtls(ProfessorDtls profDtls) {
        Integer lastId=0;
        String insertStudentData = "Insert into professor_info(address,confirm_password,department,designation,dob,education,email,first_name,gender,last_name,mobile,password,upload_img)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Query ps1 = em.createNativeQuery(insertStudentData);
            ps1.setParameter(1, profDtls.getAddress());
            ps1.setParameter(2, profDtls.getConformPassword());
            ps1.setParameter(3, profDtls.getDepartment());
            ps1.setParameter(4, profDtls.getDesignation());
            ps1.setParameter(5, profDtls.getDob());
            ps1.setParameter(6, profDtls.getEducation());
            ps1.setParameter(7, profDtls.getEmail());
            ps1.setParameter(8, profDtls.getFirstname());
            ps1.setParameter(9, profDtls.getGender());
            ps1.setParameter(10, profDtls.getLastname());
            ps1.setParameter(11, Long.parseLong(profDtls.getMobile()));
            ps1.setParameter(12, profDtls.getPassword());
            ps1.setParameter(13, profDtls.getUploadImg());
            ps1.executeUpdate();
            lastId = ((BigInteger) em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).intValue();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
       return lastId;
    }

    @Override
    public List<Object[]> getAllProfessor() {
        String allProfessors = "select * from professor_info";
        try {
            Query query = em.createNativeQuery(allProfessors);
            availableProfessors = query.getResultList();
            return availableProfessors;
        } catch (Exception e) {
           e.printStackTrace();
        }
        return availableProfessors;
    }

    @Override
    public Integer editProfDetails(ProfessorDtls profDtls) {
        Integer querySuccess =0;
        String insertStudentData = "Update professor_info SET address =? ,confirm_password=?,department=?,designation=?,dob=?,education=?,email=?,first_name=?,gender=?,last_name=?,mobile=?,password=? where id =?";

        try {
            Query ps1 = em.createNativeQuery(insertStudentData);
            ps1.setParameter(1, profDtls.getAddress());
            ps1.setParameter(2, profDtls.getConformPassword());
            ps1.setParameter(3, profDtls.getDepartment());
            ps1.setParameter(4, profDtls.getDesignation());
            ps1.setParameter(5, profDtls.getDob());
            ps1.setParameter(6, profDtls.getEducation());
            ps1.setParameter(7, profDtls.getEmail());
            ps1.setParameter(8, profDtls.getFirstname());
            ps1.setParameter(9, profDtls.getGender());
            ps1.setParameter(10, profDtls.getLastname());
            ps1.setParameter(11, Long.parseLong(profDtls.getMobile()));
            ps1.setParameter(12, profDtls.getPassword());
            ps1.setParameter(13, profDtls.getUploadImg());
            ps1.setParameter(14, profDtls.getId());
            querySuccess = ps1.executeUpdate();
            // querySuccess = ((BigInteger) em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult()).intValue();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return querySuccess;
    }
}
