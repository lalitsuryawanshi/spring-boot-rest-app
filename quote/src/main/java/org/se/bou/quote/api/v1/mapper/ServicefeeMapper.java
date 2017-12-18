package org.se.bou.quote.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.se.bou.quote.api.v1.model.ServicefeeDTO;
import org.se.bou.quote.domain.Servicefee;


@Mapper
public interface ServicefeeMapper {
	
	 ServicefeeMapper INSTANCE = Mappers.getMapper(ServicefeeMapper.class);

	 ServicefeeDTO servicefeeToServicefeeDTO(Servicefee servicefee);

	 Servicefee servicefeeDtoToServicefee(ServicefeeDTO servicefeeDTO);

}
