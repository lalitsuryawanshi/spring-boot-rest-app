package org.se.bou.quote.service;

import java.util.List;
import java.util.stream.Collectors;

import org.se.bou.quote.api.v1.mapper.AccommodationMapper;
import org.se.bou.quote.api.v1.model.AccommodationDTO;
import org.se.bou.quote.domain.Accommodation;
import org.se.bou.quote.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	private final AccommodationMapper accommodationMapper;
	private final AccommodationRepository accommodationRepository;
	
	public AccommodationServiceImpl(AccommodationMapper accommodationMapper, AccommodationRepository accommodationRepository) {
		this.accommodationMapper = accommodationMapper;
		this.accommodationRepository = accommodationRepository;
	}
	
	@Override
	public List<AccommodationDTO> getAllAccommodations() {
		return accommodationRepository
                .findAll()
                .stream()
                .map(accommodation -> {
                   AccommodationDTO accommodationDTO = accommodationMapper.accommodationToAccommodationDTO(accommodation);
                   //Set Additional Attributes here
                   return accommodationDTO;
                })
                .collect(Collectors.toList());
	}

	@Override
	public AccommodationDTO getAccommodationById(Long id) {
		return accommodationRepository.findById(id)
                .map(accommodationMapper::accommodationToAccommodationDTO)
                .map(accommodationDTO -> {
                    //set Additional attributes here
                    return accommodationDTO;
                })
                .orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public AccommodationDTO createNewAccommodation(AccommodationDTO accommodationDTO) {
		return saveAndReturnDTO(accommodationMapper.accommodationDtoToAccommodation(accommodationDTO));
	}

	@Override
	public AccommodationDTO saveAccommodationByDTO(Long id, AccommodationDTO accommodationDTO) {
		Accommodation accommodation = accommodationMapper.accommodationDtoToAccommodation(accommodationDTO);
        accommodation.setSchoolId(id);
        return saveAndReturnDTO(accommodation);
	}

	@Override
	public AccommodationDTO updateAccommodation(Long id, AccommodationDTO accommodationDTO) {
		return accommodationRepository.findById(id).map(accommodation -> {

			if(accommodationDTO.getSchoolId() != null){
				accommodation.setSchoolId(accommodationDTO.getSchoolId());
			}
			if(accommodationDTO.getPrice() != null){
				accommodation.setPrice(accommodationDTO.getPrice());
			}
			if(accommodationDTO.getAccommodationName() != null){
                accommodation.setAccommodationName(accommodationDTO.getAccommodationName());
            }

            //Set Additional Attributes
            AccommodationDTO returnDto = accommodationMapper.accommodationToAccommodationDTO(accommodationRepository.save(accommodation));

            //Set Additional Attributes
            //returnDto.setCustomerUrl(getCustomerUrl(id));

            return returnDto;

        }).orElseThrow(ResourceNotFoundException::new);
	}

	@Override
	public void deleteAccommodationById(Long id) {
		accommodationRepository.deleteById(id);
	}
	
	private AccommodationDTO saveAndReturnDTO(Accommodation accommodation) {
		
		Accommodation savedAccommodation = accommodationRepository.save(accommodation);

        AccommodationDTO returnDto = accommodationMapper.accommodationToAccommodationDTO(savedAccommodation);

        //Set Additional Attributes here

        return returnDto;
    }

	@Override
	public List<AccommodationDTO> getAllAccommodationsBySchoolId(Long schoolId) {
		return accommodationRepository.getAllAccommodationsBySchoolId(schoolId)
                .stream()
                .map(accommodation -> {
                   AccommodationDTO accommodationDTO = accommodationMapper.accommodationToAccommodationDTO(accommodation);
                   //Set Additional Attributes here
                   return accommodationDTO;
                })
                .collect(Collectors.toList());
	}


}
