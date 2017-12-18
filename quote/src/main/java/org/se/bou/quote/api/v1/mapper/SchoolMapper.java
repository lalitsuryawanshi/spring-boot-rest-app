package org.se.bou.quote.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.se.bou.quote.api.v1.model.SchoolDTO;
import org.se.bou.quote.domain.School;


@Mapper
public interface SchoolMapper {
	
	 SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);

	    SchoolDTO schoolToSchoolDTO(School school);

	    School schoolDtoToSchool(SchoolDTO schoolDTO);

}
