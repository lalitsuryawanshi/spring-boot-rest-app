package org.se.bou.quote.api.v1.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolListDTO {

	List<SchoolDTO> schools;
}
