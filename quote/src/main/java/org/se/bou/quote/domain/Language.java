package org.se.bou.quote.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Language {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long languageId;
	
	private String languageName;

}
