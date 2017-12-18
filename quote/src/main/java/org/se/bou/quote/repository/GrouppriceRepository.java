package org.se.bou.quote.repository;

import java.util.List;

import org.se.bou.quote.domain.Groupprice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GrouppriceRepository extends JpaRepository<Groupprice, Long> {
	
	/*** Custom Query for finding all Student Groups by schoolId ***************/
    @Query("SELECT t FROM Groupprice t WHERE t.courseId = :courseId") 
    List<Groupprice> getAllGrouppricesByCourseId(@Param("courseId") Long courseId);
    
    
}
