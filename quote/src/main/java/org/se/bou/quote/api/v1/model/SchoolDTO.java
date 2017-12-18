package org.se.bou.quote.api.v1.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDTO {
	
	private Long schoolId;
	private String schoolName;
	private String schoolCountry;
	private String schoolLocation;
	
	private List<CourseDTO> courses = new ArrayList<CourseDTO>();
	private List<AccommodationDTO> accommodations = new ArrayList<AccommodationDTO>();
	private List<ServicefeeDTO> servicefees = new ArrayList<ServicefeeDTO>();
	private List<ExtrafeeDTO> extrafees = new ArrayList<ExtrafeeDTO>();

}
