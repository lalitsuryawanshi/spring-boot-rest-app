package org.se.bou.quote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Groupprice {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long grouppriceId;
	
	private Long courseId;
	private Long studentgroupId;
	private Long price;

	
}
