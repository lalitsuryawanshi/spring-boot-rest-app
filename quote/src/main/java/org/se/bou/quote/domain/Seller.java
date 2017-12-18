package org.se.bou.quote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Seller {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sellerId;
	
	private String sellerName;
	private String sellerEmail;
	private String sellerPhone;
	private String sellerAddress;

}
