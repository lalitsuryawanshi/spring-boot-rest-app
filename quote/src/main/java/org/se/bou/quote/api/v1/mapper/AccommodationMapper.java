package org.se.bou.quote.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.se.bou.quote.api.v1.model.AccommodationDTO;
import org.se.bou.quote.domain.Accommodation;


@Mapper
public interface AccommodationMapper {
	
	 AccommodationMapper INSTANCE = Mappers.getMapper(AccommodationMapper.class);

	 AccommodationDTO accommodationToAccommodationDTO(Accommodation accommodation);

	 Accommodation accommodationDtoToAccommodation(AccommodationDTO accommodationDTO);

}
