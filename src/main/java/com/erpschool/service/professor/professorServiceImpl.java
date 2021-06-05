package com.erpschool.service.professor;

import com.erpschool.dao.professor.ProfessorDaoInterface;
import com.erpschool.model.professor.ProfessorDtls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

@Service
public class professorServiceImpl implements ProfessorServiceInterface {

    @Autowired
    private ProfessorDaoInterface professorDaoInterface;

    @Autowired
    ServletContext context;

    @Override
    public Boolean addNewProfessor(String profInfo, MultipartFile file)
            throws JsonMappingException, JsonProcessingException {
        Boolean professorSavedStatus = false;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ProfessorDtls profDTls = objectMapper.readValue(profInfo, ProfessorDtls.class);
            String professorImageName = getProfessorImageName(file);
            profDTls.setUploadImg(professorImageName);
            Integer result = professorDaoInterface.saveProfData(profDTls);
            if (result == 1) {
                uploadProfessorImage(file, professorImageName);
                professorSavedStatus = true;
            }
        } catch (Exception e) {
              e.printStackTrace();
        }
        return professorSavedStatus;
    }

    private String getProfessorImageName(MultipartFile file) {
        String filename = file.getOriginalFilename();
        String modifiedFileName = FilenameUtils.getBaseName(filename) + "_" + System.currentTimeMillis() + "."
                + FilenameUtils.getExtension(filename);

        return modifiedFileName;
    }

    private void uploadProfessorImage(MultipartFile file, String professorImageName) {

        boolean isExist = new File(context.getRealPath("/studentImage/")).exists();
        if (!isExist) {
            new File(context.getRealPath("/studentImage/")).mkdir();
        }
        File serverfile = new File(context.getRealPath("/studentImage/" + File.separator + professorImageName));

        try {
            FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    @Override
    public List<ProfessorDtls> getAllProfessor() {
        List<ProfessorDtls> allProfessor = new ArrayList<ProfessorDtls>();
        ProfessorDtls pDtls = new ProfessorDtls();
      List<Object[]> professorsAvailable = professorDaoInterface.getAllProfessor();
         for (Object[] obj: professorsAvailable) {
             System.out.println(obj[0].toString());
              pDtls.setId(Integer.parseInt(obj[0].toString()));
              pDtls.setAddress(obj[1].toString());
              pDtls.setConformPassword(obj[2].toString());
              pDtls.setDepartment(obj[3].toString());
              pDtls.setDesignation(obj[4].toString());
              pDtls.setDob(obj[5].toString());
              pDtls.setEducation(obj[6].toString());
              pDtls.setEmail(obj[7].toString());
              pDtls.setFirstname(obj[8].toString());
              pDtls.setGender(obj[9].toString());
              pDtls.setLastname(obj[10].toString());
              pDtls.setMobile(obj[11].toString());
              pDtls.setPassword(obj[12].toString());
              pDtls.setUploadImg(obj[13].toString());
              allProfessor.add(pDtls);
         }
        return allProfessor;
    }

    @Override
    public Boolean editProfessor(ProfessorDtls professorDtls, Integer professorId) {
        System.out.println(professorDtls + "" +professorId);
        Integer result = professorDaoInterface.editProfessorData(professorDtls , professorId);
        return null;
    }

}
