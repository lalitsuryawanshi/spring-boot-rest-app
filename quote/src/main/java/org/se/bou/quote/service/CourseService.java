package org.se.bou.quote.service;

import java.util.List;

import org.se.bou.quote.api.v1.model.CourseDTO;

public interface CourseService {

    List<CourseDTO> getAllCourses();

    CourseDTO getCourseById(Long id);

    CourseDTO createNewCourse(CourseDTO courseDTO);

    CourseDTO saveCourseByDTO(Long id, CourseDTO courseDTO);

    CourseDTO updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourseById(Long id);
    
    List<CourseDTO> getAllCoursesBySchoolId(Long schoolId);
}
