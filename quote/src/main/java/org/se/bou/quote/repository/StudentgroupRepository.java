package org.se.bou.quote.repository;

import java.util.List;

import org.se.bou.quote.domain.Studentgroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentgroupRepository extends JpaRepository<Studentgroup, Long> {
	
	/*** Custom Query for finding all Student Groups by schoolId ***************/
    @Query("SELECT t FROM Studentgroup t WHERE t.schoolId = :schoolId") 
    List<Studentgroup> getAllStudentgroupsBySchoolId(@Param("schoolId") Long schoolId);
    
    /*** Custom Query for finding Student Group Name by studentgroupId ***************/
    @Query("SELECT groupName FROM Studentgroup t WHERE t.studentgroupId = :studentgroupId") 
    String getStudentgroupNameByStudentgroupId(@Param("studentgroupId") Long studentgroupId);

    /*** Custom Query for finding Student Group Description by studentgroupId ***************/
    @Query("SELECT groupDesc FROM Studentgroup t WHERE t.studentgroupId = :studentgroupId") 
    String getStudentgroupDescByStudentgroupId(@Param("studentgroupId") Long studentgroupId);
    
}
