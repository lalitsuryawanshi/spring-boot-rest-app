package org.se.bou.quote.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicefeeDTO {
	
	private Long servicefeeId;
	private Long schoolId;
	private String serviceName;
	private Long servicePrice;

}
