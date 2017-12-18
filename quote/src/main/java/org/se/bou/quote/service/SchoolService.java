package org.se.bou.quote.service;

import java.util.List;

import org.se.bou.quote.api.v1.model.SchoolDTO;

public interface SchoolService {

    List<SchoolDTO> getAllSchools();

    SchoolDTO getSchoolById(Long id);

    SchoolDTO createNewSchool(SchoolDTO schoolDTO);

    SchoolDTO saveSchoolByDTO(Long id, SchoolDTO schoolDTO);

    SchoolDTO updateSchool(Long id, SchoolDTO schoolDTO);

    void deleteSchoolById(Long id);
}
