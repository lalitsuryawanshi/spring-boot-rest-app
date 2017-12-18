package org.se.bou.quote.repository;

import java.util.List;

import org.se.bou.quote.domain.Extrafee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExtrafeeRepository extends JpaRepository<Extrafee, Long> {

	/*** Custom Query for finding all extra fees by schoolId ***************/
    @Query("SELECT t FROM Extrafee t WHERE t.schoolId = :schoolId") 
    List<Extrafee> getAllExtrafeesBySchoolId(@Param("schoolId") Long schoolId);
	
}
