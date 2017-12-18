package org.se.bou.quote.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccommodationDTO {
	
	private Long accommodationId;
	private Long schoolId;
	private String accommodationName;
	private Long price;

}
