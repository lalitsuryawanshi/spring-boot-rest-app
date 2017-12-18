package org.se.bou.quote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class School {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long schoolId;
	
	private String schoolName;
	private String schoolCountry;
	private String schoolLocation;


}
