package org.se.bou.quote.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.se.bou.quote.api.v1.model.CourseDTO;
import org.se.bou.quote.domain.Course;


@Mapper
public interface CourseMapper {
	
	 CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

	 CourseDTO courseToCourseDTO(Course course);

	 Course courseDtoToCourse(CourseDTO courseDTO);

}
