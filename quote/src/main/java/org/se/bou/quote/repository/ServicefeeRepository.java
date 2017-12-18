package org.se.bou.quote.repository;

import java.util.List;

import org.se.bou.quote.domain.Servicefee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServicefeeRepository extends JpaRepository<Servicefee, Long> {
	
	/*** Custom Query for finding all Service Fees by schoolId ***************/
    @Query("SELECT t FROM Servicefee t WHERE t.schoolId = :schoolId") 
    List<Servicefee> getAllServicefeesBySchoolId(@Param("schoolId") Long schoolId);

}
