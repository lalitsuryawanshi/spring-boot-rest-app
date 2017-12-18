package org.se.bou.quote.api.v1.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
	
	private Long courseId;
	private Long schoolId;
	private String courseName;
	private Long courseHours;
	private Long coursePrice;
	private Long languageId;
	
	private List<GrouppriceDTO> groupPrices = new ArrayList<GrouppriceDTO>();

}
