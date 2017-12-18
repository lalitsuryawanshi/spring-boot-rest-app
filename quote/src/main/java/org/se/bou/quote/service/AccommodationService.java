package org.se.bou.quote.service;

import java.util.List;

import org.se.bou.quote.api.v1.model.AccommodationDTO;

public interface AccommodationService {

    List<AccommodationDTO> getAllAccommodations();

    AccommodationDTO getAccommodationById(Long id);

    AccommodationDTO createNewAccommodation(AccommodationDTO accommodationDTO);

    AccommodationDTO saveAccommodationByDTO(Long id, AccommodationDTO accommodationDTO);

    AccommodationDTO updateAccommodation(Long id, AccommodationDTO accommodationDTO);

    void deleteAccommodationById(Long id);
    
    List<AccommodationDTO> getAllAccommodationsBySchoolId(Long schoolId);
}
