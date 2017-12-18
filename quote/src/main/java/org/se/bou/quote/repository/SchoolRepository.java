package org.se.bou.quote.repository;

import org.se.bou.quote.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {

}
