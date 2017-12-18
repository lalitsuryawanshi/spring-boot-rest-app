package org.se.bou.quote.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentgroupDTO {
	
	private Long studentgroupId;
	private Long schoolId;
	private String groupName;
	private String groupDesc;

}
