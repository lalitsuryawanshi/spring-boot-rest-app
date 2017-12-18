package org.se.bou.quote.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.se.bou.quote.api.v1.model.StudentgroupDTO;
import org.se.bou.quote.domain.Studentgroup;


@Mapper
public interface StudentgroupMapper {
	
	 StudentgroupMapper INSTANCE = Mappers.getMapper(StudentgroupMapper.class);

	 StudentgroupDTO studentgroupToStudentgroupDTO(Studentgroup studentgroup);

	 Studentgroup studentgroupDtoToStudentgroup(StudentgroupDTO studentgroupDTO);

}
