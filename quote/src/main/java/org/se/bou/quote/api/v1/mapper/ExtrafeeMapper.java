package org.se.bou.quote.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.se.bou.quote.api.v1.model.ExtrafeeDTO;
import org.se.bou.quote.domain.Extrafee;


@Mapper
public interface ExtrafeeMapper {
	
	 ExtrafeeMapper INSTANCE = Mappers.getMapper(ExtrafeeMapper.class);

	    ExtrafeeDTO extrafeeToExtrafeeDTO(Extrafee extrafee);

	    Extrafee extrafeeDtoToExtrafee(ExtrafeeDTO extrafeeDTO);

}
