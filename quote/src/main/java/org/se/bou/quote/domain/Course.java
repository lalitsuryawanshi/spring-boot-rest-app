package org.se.bou.quote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Course {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	
	private Long schoolId;
	private String courseName;
	private Long courseHours;
	private Long coursePrice;
	private Long languageId;


}
