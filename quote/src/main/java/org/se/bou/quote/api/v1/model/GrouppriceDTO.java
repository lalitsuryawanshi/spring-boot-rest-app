package org.se.bou.quote.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GrouppriceDTO {
	
	private Long grouppriceId;
	private Long courseId;
	private Long studentgroupId;
	private Long price;
	
	private String groupName;
	private String groupDescription;

}
