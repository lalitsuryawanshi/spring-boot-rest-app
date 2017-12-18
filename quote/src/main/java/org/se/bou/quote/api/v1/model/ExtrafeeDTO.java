package org.se.bou.quote.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtrafeeDTO {
	
	private Long extrafeeId;
	private Long schoolId;
	private String extraName;
	private Long extraPrice;

}
