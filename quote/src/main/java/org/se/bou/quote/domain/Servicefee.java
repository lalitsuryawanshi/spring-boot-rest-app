package org.se.bou.quote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Servicefee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long servicefeeId;
	
	private Long schoolId;
	private String serviceName;
	private Long servicePrice;


}
