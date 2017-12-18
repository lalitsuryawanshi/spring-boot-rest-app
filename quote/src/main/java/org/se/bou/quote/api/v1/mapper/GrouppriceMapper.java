package org.se.bou.quote.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.se.bou.quote.api.v1.model.GrouppriceDTO;
import org.se.bou.quote.domain.Groupprice;


@Mapper
public interface GrouppriceMapper {
	
	 GrouppriceMapper INSTANCE = Mappers.getMapper(GrouppriceMapper.class);

	 GrouppriceDTO grouppriceToGrouppriceDTO(Groupprice groupprice);

	 Groupprice grouppriceDtoToGroupprice(GrouppriceDTO grouppriceDTO);

}
