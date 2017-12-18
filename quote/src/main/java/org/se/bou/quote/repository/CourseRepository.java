package org.se.bou.quote.repository;

import java.util.List;

import org.se.bou.quote.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends JpaRepository<Course, Long> {

	/*** Custom Query for finding all courses by schoolId ***************/
    @Query("SELECT t FROM Course t WHERE t.schoolId = :schoolId") 
    List<Course> getAllCoursesBySchoolId(@Param("schoolId") Long schoolId);
    
}
