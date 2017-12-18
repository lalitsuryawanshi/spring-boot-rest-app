package org.se.bou.quote.service;

import java.util.List;

import org.se.bou.quote.api.v1.model.StudentgroupDTO;

public interface StudentgroupService {

    List<StudentgroupDTO> getAllStudentgroups();

    StudentgroupDTO getStudentgroupById(Long id);

    StudentgroupDTO createNewStudentgroup(StudentgroupDTO studentgroupDTO);

    StudentgroupDTO saveStudentgroupByDTO(Long id, StudentgroupDTO studentgroupDTO);

    StudentgroupDTO updateStudentgroup(Long id, StudentgroupDTO studentgroupDTO);

    void deleteStudentgroupById(Long id);
    
    List<StudentgroupDTO> getAllStudentgroupsBySchoolId(Long schoolId);
}
