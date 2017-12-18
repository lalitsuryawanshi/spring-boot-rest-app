package org.se.bou.quote.repository;

import java.util.List;

import org.se.bou.quote.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
	
	/*** Custom Query for finding all Accommodations by schoolId ***************/
    @Query("SELECT t FROM Accommodation t WHERE t.schoolId = :schoolId") 
    List<Accommodation> getAllAccommodationsBySchoolId(@Param("schoolId") Long schoolId);

}
